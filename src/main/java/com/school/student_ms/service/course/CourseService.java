package com.school.student_ms.service.course;

import com.school.student_ms.dto.CourseDTO;
import com.school.student_ms.model.Course;

import java.util.List;

public interface CourseService {

    Course save(Course course);

    List<CourseDTO> getAll();

    CourseDTO getById(long id);

    void removeById(long id);

    Course updateById(long id, Course course);

    CourseDTO addTeacher(long courseId, long teacherId);
}
