

package com.school.student_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class StudentMsApplication {

	public static void main(String[] args) {

		System.out.println("Hello World!!! from Student!");
		SpringApplication.run(StudentMsApplication.class, args);
	}

}
