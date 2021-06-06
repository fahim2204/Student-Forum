package com.forum.StudentForum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class StudentForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentForumApplication.class, args);
	}

	@RestController
	public class HomeInitializer{
		@RequestMapping
		public String home(){
			return "You are on home";
		}
	}

}
