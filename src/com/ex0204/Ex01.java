package com.ex0204;

public class Ex01 {

	public static void main(String[] args) {
		Demo1 dd = new Demo1();
		System.out.println(dd.b);
		
		dd.print();
		dd.sub();
	}

}

class Test1{
	private int a=10; // 프라이빗 변수는 상속 불가능
	int b=20;
	public int c=20;
	public int d=30;
	
	public void print() {
		System.out.println(a+","+b+","+c+","+d);
	}
}

class Demo1 extends Test1{
	int d=100;
	int e=200;
	
	public void sub() {
		//System.out.println(a);
		System.out.println(b+","+c+","+d+","+super.d+","+e);
	}
	
	public void sub2() {
		print(); // super 클래스 메소드 호출
		//public 메소드 호출했으므로 private a 변수 호출 가능
	}
}