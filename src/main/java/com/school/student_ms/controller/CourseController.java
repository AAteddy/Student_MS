package com.school.student_ms.controller;


import com.school.student_ms.model.Course;
import com.school.student_ms.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.save(course));
    }

    @GetMapping("/")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable long id) {
        return ResponseEntity.ok(courseService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeById(@PathVariable long id) {
        courseService.removeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateById(@PathVariable long id, @RequestBody Course course) {
        Course updatedCourse = courseService.updateById(id, course);
        return ResponseEntity.ok(updatedCourse);
    }
}
