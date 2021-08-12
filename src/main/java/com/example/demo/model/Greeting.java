package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.controller.GreetingController;
import com.example.demo.repository.GreetingRepository;

/**
 * Add some superpowers - change the class into an JPA Entity: 
 * an object <-> a RDBMS table row
 * 
 * 
 * @see GreetingRepository
 */

@Entity
public class Greeting {

	// @Enity needs @Id
	@Id
	// Different available options for generating a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// fields mapped to a table rows
	private String clientName;
	private String greetingMsg;
	private LocalDateTime time;

	/**
	 * use code generator to create constructors / getters
	 * 
	 * @see GreetingController#greet(String)
	 */
	public Greeting(String clientName, String greetingMsg, LocalDateTime time) {
		super();
		this.clientName = clientName;
		this.greetingMsg = greetingMsg;
		this.time = time;
	}

	/**
	 * Usually Java libraries need no-arg constructors
	 * 
	 * 
	 * When we add a constructor with parameters no-arg constructor
	 * needs to be added explicitly
	 * 
	 * @see https://www.geeksforgeeks.org/constructors-in-java/
	 * 
	 */
	public Greeting() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getGreetingMsg() {
		return greetingMsg;
	}

	public void setGreetingMsg(String greetingMsg) {
		this.greetingMsg = greetingMsg;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	// Generate Getters / setters

}
