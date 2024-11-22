package com.school.student_ms.service.department;


import com.school.student_ms.model.Department;
import com.school.student_ms.repository.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentRepo departmentRepo;

    @Override
    public Department save(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

}
