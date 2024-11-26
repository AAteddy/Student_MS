package com.school.student_ms.controller;


import com.school.student_ms.dto.AddStudentDTO;
import com.school.student_ms.model.Department;
import com.school.student_ms.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @PostMapping("/register")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }


    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAll();
    }

    //add student to department
    @PutMapping("/add-student")
    public ResponseEntity<?> addStudentToDepartment(@RequestBody AddStudentDTO addStudentDTO) {
        departmentService.addStudent(addStudentDTO);
        return ResponseEntity.noContent().build();
    }

}
