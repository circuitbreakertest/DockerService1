package com.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaService1App {

	public static void main(String[] args) {

		System.setProperty("server.port", "8080");
		System.setProperty("spring.application.name", "EurekaService");
		System.setProperty("eureka.client.serviceUrl.defaultZone", "http://localhost:8761/eureka");
		System.setProperty("eureka.instance.preferIpAddress", "true");
		
		System.setProperty("management.endpoints.web.exposure.include", "*");
		System.setProperty("management.endpoints.jmx.exposure.include", "*");

		System.setProperty("info.app.name", "EurekaService1");
		System.setProperty("info.app.version", "v1.0.0");

		SpringApplication.run(EurekaService1App.class, args);
	}

	@RestController
	public class ServiceInstanceRestController {

		@Autowired
		private DiscoveryClient discoveryClient;

		@RequestMapping("/service/{applicationName}")
		public List<ServiceInstance> service(@PathVariable String applicationName) {
			return this.discoveryClient.getInstances(applicationName);
		}
		
		@RequestMapping("/test")
		public String test() throws Exception {
			throw new Exception("1233211234567");
//			return "EurekaService1";
		}
	}
}
