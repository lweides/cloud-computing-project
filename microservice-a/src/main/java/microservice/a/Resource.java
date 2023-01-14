package microservice.a;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import request.Request;
import response.Response;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/message")
public class Resource {

    private static final Logger LOG = Logger.getLogger(Resource.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Inject
    @RestClient
    Forwarder forwarder;

    @POST
    public Response foo(Request request) throws JsonProcessingException {
        LOG.info(
            "Received request from client: " + MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(request)
        );
        Response response = forwarder.forwardToB(request);
        LOG.info(
            "Received response from microservice b: " + MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(response)
        );
        return response;
    }
}
