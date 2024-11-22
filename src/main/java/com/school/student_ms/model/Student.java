package com.school.student_ms.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String gender;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
}
