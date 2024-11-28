package com.school.student_ms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue
    private long id;

    @NotNull(message = "Department Name must not be empty.")
    private String name;

    @NotNull(message = "Department Code must not be empty.")
    private String code;

    @OneToMany(mappedBy = "department")
    private Set<Student> students;

}
