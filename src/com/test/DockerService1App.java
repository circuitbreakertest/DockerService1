package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DockerService1App {

	public static void main(String[] args) {

		System.setProperty("server.port", "8080");
		System.setProperty("spring.application.name", "DockerService");

		SpringApplication.run(DockerService1App.class, args);
	}

	@RestController
	public class ServiceInstanceRestController {
		
		@RequestMapping("/test")
		public String test() throws Exception {
			throw new Exception("1233211234567");
//			return "DockerService1";
		}
	}
}
