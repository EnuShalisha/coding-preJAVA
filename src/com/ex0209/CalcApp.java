package com.ex0209;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcApp {
	public static void main(String[] args) {
		Calculate cc=new Calculate();
		cc.calc();
	}
}

class OperatorException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public OperatorException(String msg) {
		super(msg);
	}
}

class NumberException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NumberException(String msg) {
		super(msg);
	}
}

class Calculate {
	private Scanner sc=new Scanner(System.in);
	
	public void calc() {
		int a, b;
		String op;
		
		try {
			System.out.print("ù��° �� ? ");
			a = inputNumber();
			System.out.print("�ι�° �� ? ");
			b = inputNumber();
			System.out.print("������ ? ");
			op = inputOperator();
			
			String s=null;
			
			switch (op) {
			case "+":s=String.format("%d+%d=%d", a,b,a+b); break;
			case "-":s=String.format("%d-%d=%d", a,b,a-b); break;
			case "*":s=String.format("%d*%d=%d", a,b,a*b); break;
			case "/":s=String.format("%d/%d=%d", a,b,a/b); break;
			}
			System.out.println(s);
			
		} catch (ArithmeticException e) {
			System.out.println("0���� ������ �����ϴ�.");
		} catch (NumberException e) {
			System.out.println(e.getMessage());
		} catch (OperatorException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private int inputNumber() throws NumberException {
		int n=0;
		try {
			n=sc.nextInt();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw new NumberException("���ڸ� �Է� �����մϴ�.");
		}
		
		return n;
	}
	
	private String inputOperator() throws OperatorException {
		String op=null;
		
		op = sc.next();
		
		if(! op.matches("(\\+|\\-|\\*|\\/)"))
			throw new OperatorException("������ �Է� ����...");
		
		return op;
	}
}
