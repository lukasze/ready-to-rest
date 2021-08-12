package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;

/**
 * 
 * Add a superpower - a home for endpoint methods.
 * 
 * client -> GET | POST | PUT | DELETE http://localhost:8080/an-endpoint
 * 
 * Under the hood:
 * 
 * - Tomcat ( a servlet container), 
 * - Spring Mvc, 
 * - some 3-rd party libraries
 */
@RestController
public class GreetingController {

	/*
	 * Spring will inject an instance of GreetingRepository
	 * 
	 * we add @Autowired on the instance field.
	 * 
	 * @see https://reflectoring.io/constructor-injection/
	 * 
	 * 
	 */
	@Autowired
	private GreetingRepository greetingRepository;

	/**
	 * REST endpoint
	 * 
	 * GET http://localhost:8080/greeting?name=Leah -> {JSON} with "Hello, Leah!"
	 * 
	 * GET http://localhost:8080/greeting -> {JSON} with "Hello ,World!"
	 */
	@GetMapping("/greeting")
	/*
	 *  Annotation give some superpowers to classes and methods,
	 *  they usually have some attributes to change their default behavior
	 */
	public Greeting greet(@RequestParam(required = false, defaultValue = "World") String name) {
		/*
		 * Prepare a greeting message based on the received data.
		 */

		String greeting = "Hello, " + name + "!";

		/*
		 * Create a Greeting object (we don't specify the id since it will be
		 * auto-generated 
		 * 
		 * Greeting#id @GeneratedValue(strategy = GenerationType.IDENTITY)
		 * 
		 * Extras: We don't see new LocalDate() - try to debug the code to find new LocalDate()
		 */
		if (name.equals("World")) {
			name = "Default: World";
		}
		Greeting aNewGreetingToBeSaved = new Greeting(name, greeting, LocalDateTime.now());

		// Save the object (H2 DB)
		Greeting savedObject = greetingRepository.save(aNewGreetingToBeSaved);
		// Return the object from H2 to a client

		return savedObject;

	}
}
