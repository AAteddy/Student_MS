package com.school.student_ms.client.model;


import com.school.student_ms.model.enums.Gender;
import lombok.Data;


@Data
public class Teacher {

    private long id;

    private String name;

    private Gender gender;

    private Title title;
}
