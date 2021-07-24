package tech.amdeselassie.student_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.amdeselassie.student_management.model.*;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {


    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);
}
