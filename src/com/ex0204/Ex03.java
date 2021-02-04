package com.ex0204;

public class Ex03 {

	public static void main(String[] args) {
		Demo3 ob = new Demo3(1, 2);
		ob.print();

	}

}

class Test3 {
	int a;
	int b;
	
	public Test3() {
		System.out.println("인자 없는 super 생성자");
		//super(); <- object 클래스 생성자
		a=10;
		b=20;
	}
	
	public Test3(int a, int b) {
		System.out.println("인자 있는 super 생성자");
		this.a=a;
		this.b=b;
	}
}

class Demo3 extends Test3 {
	int b;
	int c;
	
	public Demo3 () {
		/*super(2,3); // 슈퍼 생성자 명시적 호출
		//단, 최상위에서 한번만.*/
		//super(5,6); this가 왔으면 super는 못불러 
		this(100, 200);
		System.out.println("인자 없는 sub 생성자");

	}
	
	public Demo3(int x, int y) {
		super(5,6);
		System.out.println("인자 있는 sub 생성자");
		b=x;
		c=y;
	}
	
	public void print() {
		System.out.println(a+","+b+","+c);
	}
}