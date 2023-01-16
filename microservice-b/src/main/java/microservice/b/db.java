package microservice.b;

import request.Request;

import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Singleton
public class db {
    List<Student> students;

    public db() {
        students = new LinkedList<>();
    }


    public Student addNewStudent(Request request) {
        Student student = new Student();
        student.setComment(request.getComment());
        student.setName(request.getName());
        student.setMatriculationNumber(request.getMatriculationNumber());

        Random random = new Random();
        student.setId(random.nextLong());

        this.students.add(student);

        return student;
    }

    public List<Student> listAllStudents() {
        return students;
    }
}
