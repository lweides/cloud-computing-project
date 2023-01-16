package microservice.a;


import org.jboss.logging.Logger;
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
    public ResponseEntity<String> healthcheck(Request request) {
        LOG.info(
                "Received healthcheck request"
        );
        return ResponseEntity.ok("Microservice A available");
    }
}

