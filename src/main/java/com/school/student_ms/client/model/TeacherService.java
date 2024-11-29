package com.school.student_ms.client.model;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class TeacherService {

    private final RestTemplate restTemplate;

    @Value("${config.server.teacher}")
    String teacherServerUrl;

    public Teacher getTeacherById(long id) {

        Teacher teacher = restTemplate.getForObject(teacherServerUrl + "/teacher/" + id, Teacher.class);

        return teacher;
    }

}
