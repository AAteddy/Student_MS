package com.school.student_ms.service;

import com.school.student_ms.model.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    Student getByName(String name);

    Student getById(long id);

    List<Student> getAll();

    void removeById(long id);

    Student updateById(long id, Student student);
}
