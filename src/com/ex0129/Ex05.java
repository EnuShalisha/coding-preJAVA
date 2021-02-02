package com.ex0129;

public class Ex05 {

	public static void main(String[] args) {
		Test5 t1=new Test5();
		t1.print();
		
		Test5 t2=new Test5(5);
		t2.print();
		
		Test5 t3=new Test5(1,3);
		t3.print();
		 

	}

}

class Test5{
	//오버로드는 가능, 오버라이딩은 불가능
	private int x;
	private int y;
	
	public Test5() {
		System.out.println("인자 없는 생성자");
		x=y=10;
	}
	public Test5(int x) {
		System.out.println("인자 하나 생성자");
		this.x=x;
		this.y=0;
	}
	
	public Test5(int x, int y) {
		System.out.println("인자 두개 생성자");
		this.x=y;
		this.y=x;
	}
	public void print() {
		System.out.println(x+","+y);
	}
		
}