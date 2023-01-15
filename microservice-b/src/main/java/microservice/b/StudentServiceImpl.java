package microservice.b;

import request.Request;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Inject
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public Student saveStudent(Request request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setComment(request.getComment());
        student.setMatriculationNumber(request.getMatriculationNumber());

        studentRepository.persistAndFlush(student);
        return student;
    }

    @Override
    public List<Student> listAllStudents() {
        return studentRepository.listAll();
    }
}
