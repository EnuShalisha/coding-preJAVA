package com.ex0129;

public class Ex3 {

	public static void main(String[] args) {
		Test3 t = new Test3(3);
		// test3(int)로 생성자만 있을 경우
		//개체를 new test3()로 만들면 컴파일에러 생김
		t.print();

	}

}

class Test3{
	int x;
	public Test3(int x) {
		System.out.println("인자가 있는 생성자");
		this.x=x;
	}
	public void print() {
		System.out.println(x);
	}
}