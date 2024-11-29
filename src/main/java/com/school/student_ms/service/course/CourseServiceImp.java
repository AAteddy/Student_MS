package com.school.student_ms.service.course;


import com.school.student_ms.client.model.Teacher;
import com.school.student_ms.client.model.TeacherService;
import com.school.student_ms.dto.CourseDTO;
import com.school.student_ms.exception.ErrorCode;
import com.school.student_ms.exception.ValidationException;
import com.school.student_ms.model.Course;
import com.school.student_ms.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepo courseRepo;
    private final TeacherService teacherService;


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
        return courseRepo.findById(id)
                .orElseThrow(() -> new ValidationException(
                        "Course with the Id = " + id + " not found"));

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

    @Override
    public CourseDTO addTeacher(long courseId, long teacherId) {
        //fetch course
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new ValidationException(
                        "Course with Id = " + courseId + " not found"
                ));

        //fetch teacher
        RestTemplate restTemplate = new RestTemplate();
        Teacher teacher = teacherService.getTeacherById(teacherId);

        //save to course
        course.setTeacherId(teacher.getId());
        courseRepo.save(course);

        CourseDTO courseDTO = getCourseDTO(course, teacher);

        return courseDTO;
    }

    private CourseDTO getCourseDTO(Course course, Teacher teacher) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setCode(course.getCode());
        courseDTO.setStudents(course.getStudents());
        courseDTO.setTeacher(teacher);
        return courseDTO;
    }
}
