package com.ex0209;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Extest1 t = new Extest1();
		
		while(true) {
		try {
			System.out.println("연산할 두 수를 입력하십시오.");
			System.out.println("첫번째: ");
			int a=sc.nextInt();
			System.out.println("두번째: ");
			int b=sc.nextInt();
			System.out.println("연산자를 입력하십시오.");
			char c=sc.next().charAt(0);
			t.operation(a, b, c);
			System.out.println("연산 완료");
			break;
		}
		catch (IOException e) {
			System.out.println("입력값이 없습니다.");
		}
		catch (InputMismatchException e) {
			System.out.println("정수만 입력할 수 있습니다.");
			sc.nextLine();}
		catch (OperException e) {
			System.out.println(e);
		}
		catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} 
		catch (Exception e) {
			System.out.println("오류 발생");
		}
		
	}
	}
}

class OperException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public OperException(String msg) {
		super(msg);
	}
	
}

class Extest1 {
	
	public void operation(int a, int b, char c) throws Exception{
		try {
			switch(c) {
			case '+': System.out.println("a+b="+(a+b)); break;
			case '-': System.out.println("a-b="+(a-b)); break;
			case '*': System.out.println("a*b="+(a*b)); break;
			case '/': System.out.println("a/b="+(a/b)); break;
			default: throw new OperException("사칙연산만 가능합니다."); 
			}
			
		} catch (ArithmeticException e) {
			throw e;
		} 
		}
	}