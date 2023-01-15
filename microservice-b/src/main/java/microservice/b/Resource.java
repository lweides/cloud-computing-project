package microservice.b;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import request.Request;
import response.Response;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api")
public class Resource {
    private static final Logger LOG = Logger.getLogger(Resource.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Inject
    @RestClient
    Forwarder forwarder;

    @GET
    @Path("/healthcheck")
    public Response healthcheck(Request request) {
        LOG.info(
                "Received healthcheck request"
        );
        return new Response("healthcheck: microservice-b available");
    }

    @POST
    @Path("/save")
    public Response saveMessage(Request request) {
        LOG.info("received message for storage");
//        Response response = forwarder.forwardToA(request);
        return new Response();
    }
}
