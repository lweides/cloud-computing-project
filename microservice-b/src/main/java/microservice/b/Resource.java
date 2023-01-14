package microservice.b;


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


@Path("/save")
public class Resource {
    private static final Logger LOG = Logger.getLogger(Resource.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Inject
    @RestClient
    Forwarder forwarder;

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response saveMessage(Request request) {
        LOG.info("received message for storage");
//        Response response = forwarder.forwardToA(request);
        return new Response();
    }
}
