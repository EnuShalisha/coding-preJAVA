package com.ex0128;

public class Ex09 {

	public static void main(String[] args) {
		Test9 t1 = new Test9();
		
		byte a=10;
		t1.print(a); // short - 매개변수 범위가 더 큰것들 중 가장 작은형
		
		char b=65;
		t1.print(b); // int
		
		//객체 자료형
		Short c=20;
		t1.print(c);
		
		int d=100;
		t1.print(d);
		
		long e=10;
		t1.print(e); // long이 없으므로 double, double이 없을경우
		//왜 Long이지? 기본자료형중에 범위에 없으면 wrapper 클래스로
		//없으면 컴파일 오류

	}

}

class Test9 {
	public void print() {
		System.out.println("인자 없는 메소드");
	}
/*	public int print() {
		return 0;
	}*/
	public void print(short a) {
		System.out.println("short: "+a);
	}
	public void print(int a) {
		System.out.println("int: "+a);
	}
	//Long : long에 대한 wrapper 클래스
	public void print(Long a) {
		System.out.println("Long: "+a);
	}
	public void print(Short a) {
		System.out.println("Short: "+a);
	}
	public void print(double a) {
		System.out.println("double: "+a);
	}
}