package com.school.student_ms.service.department;


import com.school.student_ms.dto.AddStudentDTO;
import com.school.student_ms.model.Department;

import java.util.List;

public interface DepartmentService {

    Department save(Department department);

    List<Department> getAll();

    void addStudent(AddStudentDTO addStudentDTO);

    Department getById(long id);

    void removeById(long id);

    Department updateById(long id, Department department);
}
