package request;

/**
 * Request from the outside (i.e., the client) into the k8s cluster.
 */
public class Request {
    private String matriculationNumber;
    private String name;
    private String comment;

    public Request() {
    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
