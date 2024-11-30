package com.school.student_ms.client.feign;


import com.school.student_ms.client.model.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient("TEACHER-MS/api/v1/school/teacher")
public interface TeacherFeign {

    @GetMapping("/{id}")
    ResponseEntity<Teacher> getTeacherById(@PathVariable long id);

    @GetMapping("/")
    ResponseEntity<List<Teacher>> getAllTeachers();


}
