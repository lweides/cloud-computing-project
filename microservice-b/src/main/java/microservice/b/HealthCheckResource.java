package microservice.b;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import request.Request;
import response.Response;

import javax.inject.Inject;
import javax.ws.rs.*;
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
        return ResponseEntity.ok("Microservice B available");
    }
}

