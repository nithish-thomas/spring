package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.anotate.AnotateTester;

public class Runner {
	public static void main(String[] args) {
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		
		ctx.registerShutdownHook();
		System.out.println("class found : "+ctx.getBean(AnotateTester.class));
		HelloWorld world = ctx.getBean("test",HelloWorld.class);
		
		world.testAnotations();
		/*world.getMessage();
		world = ctx.getBean("test2",HelloWorld.class);
		world.getMessage();*/
	}
}
