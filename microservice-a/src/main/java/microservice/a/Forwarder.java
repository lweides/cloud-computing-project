package microservice.a;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import request.Request;
import response.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/storage/student")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface Forwarder {

    /**
     * Forwards the POST request to service b in the k8s cluster
     * @param request to be forwarded
     * @return response produced by b
     */
    @POST
    Response forwardPostToB(Request request);

    /**
     * Forwards a GET request to service b in the k8s cluster
     * @return response produced by b
     */
    @GET
    List<Response> forwardGetToB();
}
