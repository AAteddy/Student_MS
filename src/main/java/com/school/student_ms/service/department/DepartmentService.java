package com.school.student_ms.service.department;


import com.school.student_ms.model.Department;

import java.util.List;

public interface DepartmentService {

    Department save(Department department);

    List<Department> getAll();

}
