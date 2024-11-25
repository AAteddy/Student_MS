package com.school.student_ms.controller;

import com.school.student_ms.config.StudentConfig;
import com.school.student_ms.dto.AddCourseDTO;
import com.school.student_ms.model.Student;
import com.school.student_ms.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school/student")
@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService;


    @Value("${school.urls.teacher}")
    String teacherUrl;

    @Autowired
    StudentConfig studentConfig;

    @GetMapping("/myconfig2")
    public Object getStudentConfig() {
        return studentConfig.getTeacher();
    }

    @GetMapping("/myconfig")
    public String getConfig() {
        return teacherUrl;
    }

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


    //patch a student with a list of courses
    @PatchMapping("/add-course")
    public ResponseEntity<?> addCourseToStudent(@RequestBody AddCourseDTO addCourseDTO) {
        studentService.addCourse(addCourseDTO);
        return ResponseEntity.noContent().build();
    }

}
