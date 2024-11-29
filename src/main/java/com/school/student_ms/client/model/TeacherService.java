package com.school.student_ms.client.model;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TeacherService {

    private RestTemplate restTemplate = new RestTemplate();

    public Teacher getTeacherById(long id) {

        Teacher teacher = restTemplate.getForObject("http://localhost:9999/api/v1/school/teacher/" + id, Teacher.class);

        return teacher;
    }

}
