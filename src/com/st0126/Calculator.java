package com.st0126;

public class Calculator implements Promise{
	int add(int number1, int number2) {
		int addedNum=number1+number2;
		return addedNum;
		
	}

	public void info() {
		System.out.println("Calculator Info");
		
	}

}
