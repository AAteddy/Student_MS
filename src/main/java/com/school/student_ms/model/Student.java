package com.school.student_ms.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String gender;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @ManyToOne
    private Department department;

    @ManyToMany( fetch = FetchType.LAZY )
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> course;
}
