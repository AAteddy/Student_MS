package com.student_ms.student_ms.service;

import com.student_ms.student_ms.model.Student;
import com.student_ms.student_ms.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }
}
