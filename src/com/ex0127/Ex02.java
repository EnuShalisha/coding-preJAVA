package com.ex0127;

public class Ex02 {

	public static void main(String[] args) {
		Test02 t2 = new Test02(); // Test02라는 레퍼런스 변수 선언. 레퍼런스는 클래스를 채용하는 메인 클래스 관점의 개념이다.
		//t2.c=20;
		//System.out.println(t2.b);
		System.out.println(Test02.c); //가능
		int x=Test02.c;
		//x=Test02.a; 불가능
		//private b=10 -> t2.b - 컴파일 오류, 객체따라 필드가 자동으로 생성되지 않음
		System.out.println(t2.get());
		
		Test02 tt1=new Test02(); // 0x100 주소에 필드 a, b 주소가 할당
		Test02 tt2=new Test02(); // 0x200 주소에 필드 a, b 주소가 할당
		//그러나 c는 이미 0x001 주소에 c로 할당돼있음 - 언제 호출하던 그 주소 참조
		tt1.a=10;
		
		System.out.println(tt1.a+","+tt2.a);
	}

}
class Test02 {
	//인스턴스 변수: 객체 생성해야함
	int a; //동일 패키지 클래스에서는 접근 가능
	// int b=10; t2.b=10;
	private int b=10; // 이게 은닉화의 예시 - Test02 밖 접근 불가
	//b변수 접근 방법
	public int get() {
		return b;
	}
	
	//클래스 변수: 여러개 객체 생성돼도 하나의 메모리만(=이미 선언한 값) 할당
	public static int c=30;
}