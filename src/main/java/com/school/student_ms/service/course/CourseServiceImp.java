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

    @Override
    public Course getById(long id) {
        return courseRepo.findById(id).orElseThrow(() -> {
            throw new ValidationException("Course with the Id = " + id + " not found");
        });

    }

    @Override
    public void removeById(long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Course with the Id = " + id + " not found"));

        courseRepo.delete(course);
    }

    @Override
    public Course updateById(long id, Course course) {
        Course oldCourse = courseRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Course with the Id = " + id + " not found"
                ));

        oldCourse.setName(course.getName());
        oldCourse.setCode(course.getCode());

        return courseRepo.save(oldCourse);
    }
}
