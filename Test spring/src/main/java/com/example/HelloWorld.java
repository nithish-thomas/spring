package com.example;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.anotate.AnotateTester;

public class HelloWorld {
	private String message;

	@Autowired
	private AnotateTester tester;
	
	public HelloWorld() {
		System.out.println("Initializing hello world with default constructor");
	}

	public HelloWorld(String msg) {
		System.out.println("Initializing hello world "+msg);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println("Your Message : " + message);
	}

	public void init() {
		System.out.println("Bean is going through init.");
	}

	public void destroy() {
		System.out.println("Bean will destroy now.");
	}
	
	public void testAnotations(){
		System.out.println("Getting anotated value of msg :"+tester.msg);
	}
	
	
}
