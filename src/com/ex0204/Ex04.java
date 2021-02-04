package com.ex0204;

public class Ex04 {

	public static void main(String[] args) {
		Demo4 d = new Demo4();

	}

}

class Test4 {
	int a;
	
	public Test4(int a) {
		this.a=a;
		System.out.println("super 인자 있");
	}
}

class Demo4 extends Test4{
	//왜 바로 오류가 나는가? super 생성자를 파라미터 없이 자동으로 만들었기 때문
	//이경우 반드시 명시적 생성자가 필요하다
	
	public Demo4() {
		super(1);
	}
}