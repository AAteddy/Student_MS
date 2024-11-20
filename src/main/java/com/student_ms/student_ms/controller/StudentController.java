package com.student_ms.student_ms.controller;

import com.student_ms.student_ms.model.Student;
import com.student_ms.student_ms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/register")
    public Student create(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/{name}")
    public Student getByName(@PathVariable String name) {
        return studentService.getByName(name);
    }

    @GetMapping("/hello")
    public String greet() {
        return "Hello World!!! from student controller, for testing!";
    }
}
