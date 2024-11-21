

package com.school.student_ms.service;

import com.school.student_ms.model.Student;
import com.school.student_ms.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public void removeById(long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Student not found with ID: " + id)
                );
        studentRepo.delete(student);
    }

    @Override
    public Student updateById(long id, Student student) {
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Student not found with ID: " + id)
                );
        existingStudent.setName(student.getName());
        existingStudent.setGender(student.getGender());

        studentRepo.save(existingStudent);
        return existingStudent;
    }

    @Override
    public Student getByName(String name) {
        Student student = studentRepo.findByName(name);
        if (student == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student not found with name: " + name);
        }
        return student;
    }

    @Override
    public Student getById(long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Student not found with ID: " + id)
                );
    }

}
