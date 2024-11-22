package com.school.student_ms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String code;

    @OneToMany(mappedBy = "department")
    private Set<Student> students;

}
