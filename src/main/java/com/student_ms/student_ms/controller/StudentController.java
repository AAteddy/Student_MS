package com.student_ms.student_ms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @GetMapping("/greetings")
    public String greet() {
        return "Hello there from student controller!";
    }

    @GetMapping("/bye")
    public String goodBye() {
        return "Good Bye from student controller!";
    }
}
