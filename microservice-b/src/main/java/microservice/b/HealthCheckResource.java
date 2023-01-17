package microservice.b;


import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;
import org.springframework.http.ResponseEntity;
import request.Request;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api")
public class HealthCheckResource {
    private static final Logger LOG = Logger.getLogger(HealthCheckResource.class);

    @GET
    @Path("/healthcheck")
    public String healthcheck(Request request) {
        LOG.info(
                "Received healthcheck request"
        );
        return "Microservice B available";
    }
}

