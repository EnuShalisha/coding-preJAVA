package com.st0126;

class Example{
	static String name = "Rin"; // 대신 name 변수는 고정
	//String name = "Rin"; static 아니면 밑에서 에러 발생
	void showName() { //static 아닌 메소드에서 static 변수 사용 가능
		System.out.println(name);
	
	//public static final double PI = 3.141592......
	}
}
public class Ex04 {

	public static void main(String[] args) {
		System.out.println(Example.name); // 이게 객체화시키지 않아도 되는것
		
		Example ex = new Example();
		System.out.println(ex.name);
		
		ex.showName();
		// Example.showName(); static 아니므로 객체화 없으면 실행x
		
		final int ID=1; // 전부 대문자
		// ID=3; 컴파일 에러
		// Math.PI=1.9; 컴파일에러

	}

}
