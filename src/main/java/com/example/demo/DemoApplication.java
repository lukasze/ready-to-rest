package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * The main configuration class
 * 
 * - @Configuration
 * - @EnableAutoConfiguration
 * - @ComponentScan
 * 
 *
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
//		Replace with the below code to list all spring beans	
//		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}

}
