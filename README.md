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

## Setup ##

### Microservice A ###

1. Run the `mvn install` command

2. Run the `mvn compile quarkus:dev` command

3. Test connection using the following command:
   ```console
      curl -X POST http://localhost:8080/api/healthcheck
   ```
4. Use the `mvn package -DskipTests` to build the application. It will generate a single JAR that contains all the classes of your application including its dependencies.

5. Build the docker image with the following command:
   ```console
      docker build -f src/main/docker/Dockerfile.jvm -t quarkus/microservice-b-jvm .
   ```
6. Run `docker images|grep quarkus`

   ```console
      quarkus/microservice-a-jvm                      latest    e3a2dc357a42   7 minutes ago   422MB
   ```

7. Set the name of the image in the kubernetes.yml file:
   ```console
            containers:
        - env:
            - name: KUBERNETES_NAMESPACE
              valueFrom:
                fieldRef:
                  fieldPath: metadata.namespace
          image: quarkus/microservice-a-jvm:latest #HERE
          imagePullPolicy: Always
          name: microservice-a
          ports:
            - containerPort: 8080
              name: http
              protocol: TCP
   ```

8. Apply the deployment to your Kubernetes cluster using:
   ```console
      kubectl apply -f target/kubernetes/kubernetes.yml
   ```
   
9. You can see all your active deployments (in your current namespace) by executing:
   ```console
      kubectl get deployments
   ```

   ```console
      NAME             READY   UP-TO-DATE   AVAILABLE   AGE
      microservice-a   0/1     1            0           71s
   ```



### Microservice B ###

1. Run the `mvn install` command

2. Run the `mvn compile quarkus:dev` command

3. Test connection using the following command:
   ```console
      curl -X POST http://localhost:8081/api/healthcheck
   ```

1. Run the `mvn install` command
### Microservice C ###
