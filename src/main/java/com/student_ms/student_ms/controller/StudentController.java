package com.student_ms.student_ms.controller;

import com.student_ms.student_ms.model.Student;
import com.student_ms.student_ms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/hello")
    public String greet() {
        return "Hello World!!! from student controller, for testing!";
    }

    @PostMapping("/register")
    public Student create(@RequestBody Student student) {
        return studentService.save(student);
    }

    //get all students
    @GetMapping("/")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    //get a student by Id
    @GetMapping("/{id}")
    public Student getById(@PathVariable long id) {
        return studentService.getById(id);
    }

    //delete a student by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeById(@PathVariable long id) {
        studentService.removeById(id);
        return ResponseEntity.noContent().build();
    }

    //update a student by Id
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateById(@PathVariable long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateById(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    //get student by name
    @GetMapping("/name/{name}")
    public Student getByName(@PathVariable String name) {
        return studentService.getByName(name);
    }

}
