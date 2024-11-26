package com.school.student_ms.service.department;


import com.school.student_ms.exception.ErrorCode;
import com.school.student_ms.exception.ValidationException;
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
        //validation
        if(department.getName() == null || department.getCode() == null)
            throw new ValidationException("Department Name or Code must not be empty.", ErrorCode.DEPARTMENT_ERROR);

        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

}
