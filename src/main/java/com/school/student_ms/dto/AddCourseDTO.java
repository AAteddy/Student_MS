package com.school.student_ms.dto;

import lombok.Data;

import java.util.List;


@Data
public class AddCourseDTO {

    private long studentId;

    private List<Long> courseIds;
}
