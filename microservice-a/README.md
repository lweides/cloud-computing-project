# Microservice A

It forwards requests to Microservice B.

## Required configuration
In `src/main/resources/application.properties`, change property `quarkus.rest-client."microservice.a.Forwarder".url` to point to microservice B.
