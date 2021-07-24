package tech.amdeselassie.student_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.amdeselassie.student_management.exception.UserNotFoundException;
import tech.amdeselassie.student_management.model.Student;
import tech.amdeselassie.student_management.repo.StudentRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StudentService {
    private final StudentRepo studentrepo;

    @Autowired
    public StudentService(StudentRepo studentrepo) {
        this.studentrepo = studentrepo;
    }

    public Student addStudent(Student student){
        student.setstudentCode(UUID.randomUUID().toString());
        return studentrepo.save(student);
    }

    public List<Student> findAllStudents(){
        return studentrepo.findAll();
    }

    public Student updateStudent(Student student){
        return studentrepo.save(student);
    }

    public Student findStudentById(Long id){
        return studentrepo.findStudentById(id).orElseThrow(() -> new UserNotFoundException("User by id" + id + "not found"));

    }

    public void deleteStudent(Long id){
        studentrepo.deleteStudentById(id);
    }


}
