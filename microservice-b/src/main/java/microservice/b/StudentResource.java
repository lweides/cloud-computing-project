package microservice.b;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import request.Request;
import response.Response;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {
    private static final Logger LOG = Logger.getLogger(StudentResource.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final StudentService studentService;

    @Inject
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @POST
    public ResponseEntity<Response> saveMessage(Request request) {
        LOG.info("Received message for storage");
        try {
            Student student = studentService.saveStudent(request);
            Response response = StudentMapper.toSingleResponse(student);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GET
    public ResponseEntity<List<Response>> listAllStudents() {
        LOG.info("Received message to list all students");
        try {
            List<Student> students = studentService.listAllStudents();
            List<Response> response = StudentMapper.toListResponse(students);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}