# Documentation #

## Structure ##
The entire project consists of three different microservices:
 - Microservice A
 - Microservice B
 - Microservice C

TODO: Microservices Zuständigkeiten erklären - Was machen sie

A helper project called shared serves as the purpose of defining a global communication standard.
In detail, the request and response classes for communication via REST across Microservice A and B are defined.

## Technologies ##
TODO Maven etc

### High Level System Architecture ###
![Architecture of our K8s cluster](architecture.jpg "Architecture")
 
## Prerequisites ##

1. Account in [Google Cloud](http://cloud.google.com/)

2. Install the [Google Cloud SDK](https://cloud.google.com/sdk/install). After installing the Google Cloud SDK, you have the command-line tool *gcloud* available in your terminal.

   Run the command:
    ```console
    gcloud version
    ```

3. Run the `kubectl` installation command:

   ```console
   gcloud components install kubectl

4. GKE Cluster up and running. Follow the steps as described in [GKE cluster setup](https://github.com/clc3-CloudComputing/ws22/tree/main/3%20Kubernetes/exercise%203.1)

5. JDK 11+ installed with JAVA_HOME configured appropriately

6. Apache Maven

7. Docker Deamon

8. Pull this repository

9. Dynatrace SaaS/Managed Account. Get your free SaaS trial [here](https://www.dynatrace.com/trial/).

## Setup ##

### Microservice A ###

1. Switch to microservice-a directory

2. Run the `mvn install` command

3. Run the `mvn compile quarkus:dev` command

4. Test connection using the following command:
   ```console
      curl http://localhost:8080/api/healthcheck
   
      {"headers":{},"body":"Microservice A available","statusCodeValue":200,"statusCode":"OK"}
   ```

5. Set property `quarkus.container-image.group` in file `application.properties` to the Docker Hub username

6. Use the `mvn package -DskipTests` to build the application. It will generate a single JAR that contains all the classes of your application including its dependencies.

7. Build the docker image with the following command:
   ```console
      docker build -f src/main/docker/Dockerfile.jvm -t <hub-user>/microservice-a:1.0.0 .
   ```
8. Run `docker images|grep <hub-user>`

   ```console
      <hub-user>/microservice-a               1.0.0     e3a2dc357a42   7 min ago     422MB  422MB
   ```

9. Login to Docker Hub with `docker login`

10. Push Docker container image to Docker Hub:
    ```console
       docker push <hub-user>/microservice-a:1.0.0
    ```

11. Apply the deployment to your Kubernetes cluster using:
    ```console
       kubectl apply -f target/kubernetes/kubernetes.yml
    ```
   
12. You can see all your active pods by executing `kubectl get pods`

    ```console
       NAME                              READY   STATUS    RESTARTS   AGE
       microservice-a-7c788bbf6c-6hv6d   1/1     Running   0          13s
    ```

13. Use port-forwarding to access the service:

   ```console
       kubectl port-forward service/microservice-a 8080:http
    ```
   
14. Test connection:

   ```console
      curl http://localhost:8080/api/healthcheck
   ```
   ```console
      {"headers":{},"body":"Microservice A available","statusCodeValue":200,"statusCode":"OK"}
   ```



### Microservice B ###

1. Switch to microservice-b directory

2. Run the `mvn install` command

3. Run the `mvn compile quarkus:dev` command

4. Test connection using the following command:
   ```console
      curl http://localhost:8081/api/healthcheck
   
      {"headers":{},"body":"Microservice B available","statusCodeValue":200,"statusCode":"OK"}
   ```
   
5. Set property `quarkus.container-image.group` in file `application.properties` to the Docker Hub username   

6. Use the `mvn package -DskipTests` to build the application. It will generate a single JAR that contains all the classes of your application including its dependencies.

7. Build the docker image with the following command:
   ```console
      docker build -f src/main/docker/Dockerfile.jvm -t <hub-user>/microservice-b:1.0.0 .
   ```
8. Run `docker images|grep <hub-user>`

   ```console
      <hub-user>/microservice-a               1.0.0     e3a2dc357a42   7 min ago     422MB  422MB
      <hub-user>/microservice-b               1.0.0     fc67d184a8f2   8 seconds ago   410MB

   ```

9. Login to Docker Hub with `docker login`

10. Push Docker container image to Docker Hub:
    ```console
       docker push <hub-user>/microservice-a:1.0.0
    ```

11. Apply the deployment to your Kubernetes cluster using:
    ```console
       kubectl apply -f target/kubernetes/kubernetes.yml
    ```

12. You can see all your active pods by executing `kubectl get pods`

    ```console
       NAME                              READY   STATUS    RESTARTS   AGE
       microservice-a-89b964bc-plb2j     1/1     Running       0          3h22m
       microservice-b-84dd55d6b8-vcn7f   1/1     Running       0          4s
    ```

13. Use port-forwarding to access the service:

```console
    kubectl port-forward service/microservice-b 8081:http
 ```

14. Test connection:

```console
   curl http://localhost:8081/api/healthcheck
```
```console
   {"headers":{},"body":"Microservice B available","statusCodeValue":200,"statusCode":"OK"}
```

### Microservice C ###

### Setup Dynatrace Monitoring ###

1. Enable autoscaling

2. In the Dynatrace application navigate to Deploy Dynatrace → Install OneAgent → Kubernetes / OpenShift and follow the described steps

