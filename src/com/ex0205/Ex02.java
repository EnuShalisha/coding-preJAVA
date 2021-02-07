package com.ex0205;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//파이널 클래스는 하위 작성 불가
final class Test02{
	//final 변수 초기화: 선언시, 초기화블럭, 생성자
	//반드시 초기화해야함
	public final int a=10;
	
	public final int b;
	
	public Test02() {
		b=100;
	}
	
	public void sub() {
		//a=5; 겂 변경 불가
	}
}

class Sample02 {
	public final void sub() {
		System.out.println("sub");
	}
}

class Demo02 extends Sample02{
	//public void sub() {
		//System.out.println("[sub]"); 재정의 불가
}