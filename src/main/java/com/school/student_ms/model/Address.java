package com.school.student_ms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private long id;

    private String city;

    private String country;

}
