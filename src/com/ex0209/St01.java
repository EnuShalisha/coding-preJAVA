package com.ex0209;

import java.util.Scanner;

public class St01 {
//2. 위에서 처리하는 방법
	public static void main(String[] args) {
	//예외: 0 미만의 수는 받을 수없다. underzeroexception
		int a;
		try {
			System.out.println("수 입력");
			Scanner sc = new Scanner(System.in);
			a=sc.nextInt();//a=-1
			Demo1.check(a);
		} catch (Underzeroexception e)
		{System.out.println("0보다 작습니다");}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
//1. 밑에서 처리하는 방법 System.out.println(e.tostring);
class Demo1 {
	public static void check(int a) throws Exception{
		try {
			if(a<0)
				throw new Underzeroexception("0 미만의 수는 입력 불가");
				System.out.println("0보다 작지 않습니다");
		} catch (Underzeroexception e) {
			throw e;

		}
	}
}

class Underzeroexception extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Underzeroexception(String msg) {
		super(msg);
	}
}