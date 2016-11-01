package com.example.anotate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnotateTester {
	@Autowired(required=true)
	public String msg;
	
	public static AnotateTester tester=new AnotateTester();
	
	public static AnotateTester getAnoationTester(){
		return tester;
	}
}
