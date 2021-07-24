package tech.amdeselassie.student_management.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.amdeselassie.student_management.service.StudentService;
import tech.amdeselassie.student_management.model.Student;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentResource {

    private final StudentService studentService;

    public StudentResource(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List <Student>> getAllStudents(){

        List<Student> students = studentService.findAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Student> geStudentByID(@PathVariable("id") Long id){

        Student students = studentService.findStudentById(id);

        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudents(@RequestBody Student student){


        Student newstudents = studentService.addStudent(student);


        return new ResponseEntity<>(newstudents, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudents(@RequestBody Student student){

        Student updatestudents = studentService.updateStudent(student);

        return new ResponseEntity<>(updatestudents, HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudents(@PathVariable("id") Long id){

        studentService.deleteStudent(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
