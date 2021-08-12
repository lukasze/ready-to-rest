package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.controller.GreetingController;
import com.example.demo.model.Greeting;

/**
 * 
 * Add some superpowers - extend one of the spring data interfaces:
 * 
 *	<T, ID> - generic interface - we replace T with entity type, ID with primary key type
 * 
 * Under the hood:
 * - spring data (provides implementations  using Java Reflection API)
 * - Hibernate ( a JPA implementation)
 * - jdbc (Hibernate uses it to interact with DB
 * 
 * @see GreetingController 
 */
public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
