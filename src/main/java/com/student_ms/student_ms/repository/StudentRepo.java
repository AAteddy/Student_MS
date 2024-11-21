package com.student_ms.student_ms.repository;

import com.student_ms.student_ms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    Student findByName(String student);

}
