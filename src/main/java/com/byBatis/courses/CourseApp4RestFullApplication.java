package com.byBatis.courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
public class CourseApp4RestFullApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApp4RestFullApplication.class, args);
	}

}
