package com.example.anotate;

public class Test extends TestAbstract{

	private int size;
	
	public Test() {
		size=7;
	}
	
	@Override
	public int getWidth() {
		return size;
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		System.out.println(t.getSize());
	}

}
