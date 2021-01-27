package com.st0126;

public class Ex02 {

	public static void main(String[] args) {
		Person p1=new Person();
		p1.name="Rin";
		String myName = p1.getName();	
		int myage = p1.getAge()+6;
		System.out.println(myage);
		
		Calculator c1=new Calculator();
		System.out.println(c1.add(1,2));

	}

}
