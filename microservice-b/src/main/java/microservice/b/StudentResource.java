package microservice.b;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import request.Request;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/storage/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {
    private static final Logger LOG = Logger.getLogger(StudentResource.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final Db db;

    @Inject
    public StudentResource(Db db) {
        this.db = db;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Student saveMessage(Request request) {
        LOG.info("Received message for storage: " + request.getComment());
        Student student = db.addNewStudent(request);
        return student;
    }

    @GET
    public List<Student> listAllStudents() {
        LOG.info("Received message to list all students");
        return db.listAllStudents();
    }
}
