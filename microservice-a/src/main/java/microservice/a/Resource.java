package microservice.a;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import request.Request;
import response.Response;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/student")
public class Resource {

    private static final Logger LOG = Logger.getLogger(Resource.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Inject
    @RestClient
    Forwarder forwarder;

    @POST
    public Response create(Request request) throws JsonProcessingException {
        LOG.info(
            "Received POST request from client: " + MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(request)
        );
        Response response = forwarder.forwardPostToB(request);
        LOG.info(
            "Received response from microservice b: " + MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(response)
        );
        return response;
    }

    @GET
    public List<Response> get() throws JsonProcessingException {
        LOG.info("Received GET request from client");
        List<Response> responses = forwarder.forwardGetToB();
        LOG.info(
            "Received response from microservice b: " + MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(responses)
        );
        return responses;
    }
}
