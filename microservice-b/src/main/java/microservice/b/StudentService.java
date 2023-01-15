package microservice.b;

import request.Request;

import java.util.List;

public interface StudentService {

    Student saveStudent(Request request);

    List<Student> listAllStudents();
}
