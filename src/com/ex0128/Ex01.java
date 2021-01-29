package com.ex0128;

public class Ex01 {

	public static void main(String[] args) {
		Test t1 = new Test();
		t1.a = 5;
		t1.print();
		
		System.out.println(Test.c);
		System.out.println(t1.c); // 개체 접근 가능은 하나 권장하진 않음

	}

}

class Test{
	int a; // 인스턴스 변수는 개체 생성 시점에 메모리 할당 -> 개체 생성돼야 사용 가능
	private int b=10;
	public static int c=20; // 클래스 변수는 클래스 로딩 시점에 메모리 할당받음 -> 개체 생성과 관계 없이 사용
	
	public Test() {
		
	} // 이 생성자를 컴파일러에선 자동으로 만들어줌 - 기본적으로 생략됨
	public void print() { // 언제든 접근할수는 있는데 실행은 아님 -> 개체 생성 후 메모리할당
		System.out.println(a+","+b+","+c);
	}
	
	public void sub() {
		print(); // 인스턴스 변수도
		write(); // 클래스 변수도 어차피 개체 생성 후라서 지금 접근 가능
	}
	
	public static void write() { // 클래스 메소드 - 객체생성 관계 없이 접근
		// System.out.println(a);
		// System.out.println(b);
		System.out.println(c);
		//System.out.println(print()); 인스턴스 메소드 접근 불가
		Test t = new Test();
		System.out.println(t.a+","+t.b);
		t.print();
	}
}