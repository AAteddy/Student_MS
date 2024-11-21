package com.school.student_ms.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@Data
@ConfigurationProperties(prefix = "school.urls")
public class StudentConfig {
    private String teacher;
    private String management;
}
