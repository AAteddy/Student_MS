

package com.school.student_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class StudentMsApplication {

	public static void main(String[] args) {

		System.out.println("Hello World!!! from Student!");
		SpringApplication.run(StudentMsApplication.class, args);
	}

}
