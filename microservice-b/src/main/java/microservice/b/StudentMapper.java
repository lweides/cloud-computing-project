package microservice.b;

import response.Response;

import java.util.LinkedList;
import java.util.List;

public class StudentMapper {

    public static Response toSingleResponse(Student student) {
        Response response = new Response();

        response.setId(student.getId());
        response.setName(student.getName());
        response.setComment(student.getComment());
        response.setMatriculationNumber(student.getMatriculationNumber());

        return response;
    }

    public static List<Response> toListResponse(List<Student> students){
        List<Response> responses = new LinkedList<>();

        students.forEach(student -> {
            responses.add(toSingleResponse(student));
        });

        return responses;
    }
}
