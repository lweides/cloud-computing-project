package microservice.b;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;
import request.Request;
import response.Response;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

import static org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;


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

    @Inject
    @RestClient
    Forwarder forwarder;

    @POST
    public RestResponse<Response> saveMessage(Request request) {
        LOG.info("Received message for storage");
        Response response = new Response();
        try {
            response = StudentMapper.toSingleResponse(studentService.saveStudent(request));
            return ResponseBuilder.ok(response).build();
        } catch (Exception e) {
            response.setStatusCode(400);
            return ResponseBuilder.ok(response).build();
        }
    }

    @GET
    public RestResponse<List<Response>> listAllStudents() {
        LOG.info("Received message to list all students");
        List<Response> response = new LinkedList<>();

        try {
            response = StudentMapper.toListResponse(studentService.listAllStudents());
            return ResponseBuilder.ok(response).build();
        } catch (Exception e) {
            return ResponseBuilder.ok(response).build();
        }
    }
}
