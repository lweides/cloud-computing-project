package microservice.a;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import request.Request;
import response.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


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
