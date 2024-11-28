package com.school.student_ms.service.department;


import com.school.student_ms.dto.AddStudentDTO;
import com.school.student_ms.exception.ErrorCode;
import com.school.student_ms.exception.ValidationException;
import com.school.student_ms.model.Course;
import com.school.student_ms.model.Department;
import com.school.student_ms.model.Student;
import com.school.student_ms.repository.DepartmentRepo;
import com.school.student_ms.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpClient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final StudentRepo studentRepo;

    @Override
    public Department save(Department department) {
        //validation
        if(department.getName() == null || department.getCode() == null)
            throw new ValidationException("Department Name or Code must not be empty.");

        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    @Override
    public void addStudent(AddStudentDTO addStudentDTO) {
        Department department = departmentRepo.findById(addStudentDTO.getDepartmentId())
                .orElseThrow(() -> {
                    throw new ValidationException("Department with Id = " + addStudentDTO.getDepartmentId() + " could not be found");
                });

        List<Student> stdList = studentRepo.findAllById(addStudentDTO.getStudentIds());
        if(stdList.isEmpty())
            throw new ValidationException("Student with Id = " + addStudentDTO.getStudentIds() + " could not be found");

        Set<Student> stdSet = new HashSet<>(stdList);

        department.setStudents(stdSet);
        departmentRepo.save(department);
    }

    @Override
    public Department getById(long id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new ValidationException(
                        "Department with Id = " + id + " not found"));
    }

    @Override
    public void removeById(long id) {
        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Department with Id = " + id + " not found"));

        departmentRepo.delete(department);
    }

    @Override
    public Department updateById(long id, Department department) {
        Department existingDepartment = departmentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Department with Id = " + id + " not found"
                ));

        existingDepartment.setName(department.getName());
        existingDepartment.setCode(department.getCode());

        return departmentRepo.save(existingDepartment);
    }

}
