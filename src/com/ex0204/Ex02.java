package com.ex0204;

public class Ex02 {

	public static void main(String[] args) {
		Demo2 ob = new Demo2();
		//demo를 만든다는게 test에게도 메모리 할당돼야하고,
		//생성자가 없으면 메모리 할당이 끝나지 않을때있음
		//그러므로 super 생성자를 만듬
		ob.write();

	}

}

class Test2{
	int a=10;
	int b=20;
	
	{
		System.out.println("메인 초기화 블럭");
	}
	public Test2() {
		System.out.println("super 생성자");
	}
}
class Demo2 extends Test2{
	int b=30;
	int c=40;
	
	{
		System.out.println("sub 초기화 블럭");
	}
	
	public Demo2() {
		super(); // sub 클래스에선 원래 숨겨져있던 default 생성자
		System.out.println("데모 생성자");
	} // 생성자를 안만들던 super를 안붙이던, super 생성자를 불러옴
	
	public void write() {
		System.out.println(a+","+b+","+c);
	}
}