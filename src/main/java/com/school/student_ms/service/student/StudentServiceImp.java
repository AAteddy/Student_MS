

package com.school.student_ms.service.student;

import com.school.student_ms.dto.AddCourseDTO;
import com.school.student_ms.model.Course;
import com.school.student_ms.model.Student;
import com.school.student_ms.repository.CourseRepo;
import com.school.student_ms.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return studentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Student not found with ID: " + id)
                );
    }


    @Override
    public void addCourse(AddCourseDTO addCourseDTO) {
        //fetch student
        Optional<Student> stdOpt = studentRepo.findById(addCourseDTO.getStudentId());
        if(stdOpt.isPresent()) {
            //fetch courses
            List<Course> courseList = courseRepo.findAllById(addCourseDTO.getCourseIds());
            //convert (courseList) to set
            Set<Course> courseSet = courseList.stream().collect(Collectors.toSet());

            //set to a student
            Student std = stdOpt.get();
            std.setCourse(courseSet);
            studentRepo.save(std);
        }

    }

}
