package com.school.student_ms.service.course;

import com.school.student_ms.model.Course;

import java.util.List;

public interface CourseService {

    Course save(Course course);

    List<Course> getAll();

    Course getById(long id);

    void removeById(long id);

    Course updateById(long id, Course course);
}
