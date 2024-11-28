

package com.school.student_ms.service.student;

import com.school.student_ms.dto.AddCourseDTO;
import com.school.student_ms.exception.ErrorCode;
import com.school.student_ms.exception.ValidationException;
import com.school.student_ms.model.Course;
import com.school.student_ms.model.Student;
import com.school.student_ms.repository.CourseRepo;
import com.school.student_ms.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {


    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    @Override
    public Student save(Student student) {
        //validate name
//        if(student.getName() == null || student.getGender() == null)
//            throw new ValidationException("Student Name or Gender must not be empty.", ErrorCode.STUDENT_ERROR);

        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public void removeById(long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Student not found with ID: " + id)
                );
        studentRepo.delete(student);
    }

    @Override
    public Student updateById(long id, Student student) {
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Student not found with ID: " + id)
                );
        existingStudent.setName(student.getName());
        existingStudent.setGender(student.getGender());

        studentRepo.save(existingStudent);
        return existingStudent;
    }

    @Override
    public Student getByName(String name) {
        Student student = studentRepo.findByName(name);
        if (student == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student not found with name: " + name);
        }
        return student;
    }

    @Override
    public Student getById(long id) {
        Student student = studentRepo.findById(id).orElseThrow(() -> {
            throw new ValidationException("Student with Id = " + id + " could not be found", ErrorCode.STUDENT_ERROR);
        });

        return student;
    }


    @Override
    public void addCourse(AddCourseDTO addCourseDTO) {
        //fetch student
//        Optional<Student> stdOpt = studentRepo.findById(addCourseDTO.getStudentId());
        Student std = studentRepo.findById(addCourseDTO.getStudentId())
                .orElseThrow(() -> {
                    throw new ValidationException("Student with Id = " + addCourseDTO.getStudentId() + " could not be found", ErrorCode.STUDENT_ERROR);
                });
//        if(stdOpt.isPresent()) {
            //fetch courses
            List<Course> courseList = courseRepo.findAllById(addCourseDTO.getCourseIds());
            if(courseList.isEmpty())
                throw new ValidationException("Course with Id = " + addCourseDTO.getCourseIds() + " could not be found", ErrorCode.COURSE_ERROR);

            //convert (courseList) to set
            Set<Course> courseSet = new HashSet<>(courseList);

            //set to a student
//            Student std = stdOpt.get();
            std.setCourse(courseSet);
            studentRepo.save(std);
//        }

    }

}
