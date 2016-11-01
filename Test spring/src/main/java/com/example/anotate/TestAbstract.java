package com.example.anotate;

public abstract class TestAbstract {
	private int size;
	public TestAbstract() {
		size=getWidth();
	}
	
	abstract public int getWidth();
	
	public int getSize(){
		return size;
	}
}
