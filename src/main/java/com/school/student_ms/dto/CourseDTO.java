package com.school.student_ms.dto;


import com.school.student_ms.client.model.Teacher;
import com.school.student_ms.model.Student;
import lombok.Data;

import java.util.Set;


@Data
public class CourseDTO {

    private long id;

    private String name;

    private String code;

    private Set<Student> students;

    private Teacher teacher;

}
