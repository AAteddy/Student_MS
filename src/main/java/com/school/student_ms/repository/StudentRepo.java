package com.school.student_ms.repository;

import com.school.student_ms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    Student findByName(String student);

}
