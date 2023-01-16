package microservice.b;

import request.Request;

import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Singleton
public class Db {
    List<Student> students;

    public Db() {
        students = new LinkedList<>();
    }


    public Student addNewStudent(Request request) {
        Student student = new Student();
        student.setComment(request.getComment());
        student.setName(request.getName());
        student.setMatriculationNumber(request.getMatriculationNumber());

        int rand = (int)(Math.random()*100);
        student.setId(Long.valueOf(rand));

        this.students.add(student);

        return student;
    }

    public List<Student> listAllStudents() {
        return students;
    }
}
