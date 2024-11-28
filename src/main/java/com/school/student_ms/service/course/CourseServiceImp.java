package com.school.student_ms.service.course;


import com.school.student_ms.exception.ErrorCode;
import com.school.student_ms.exception.ValidationException;
import com.school.student_ms.model.Course;
import com.school.student_ms.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public Course save(Course course) {
        //validation
        if(course.getName() == null || course.getCode() == null)
            throw new ValidationException("Course Name and Code must be empty.");

        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.findAll();
    }


}
