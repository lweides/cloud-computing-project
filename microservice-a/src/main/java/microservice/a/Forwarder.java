package microservice.a;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import request.Request;
import response.Response;


@Path("/api/save")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface Forwarder {

    /**
     * Forwards the request to service b in the k8s cluster
     * @param request to be forwarded
     * @return response produced by b
     */
    @POST
    Response forwardToB(Request request);
}
