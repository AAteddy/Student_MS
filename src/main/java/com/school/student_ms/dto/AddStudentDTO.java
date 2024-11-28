
package com.school.student_ms.dto;


import lombok.Data;

import java.util.List;


@Data
public class AddStudentDTO {

    private long departmentId;

    private List<Long> studentIds;
}
