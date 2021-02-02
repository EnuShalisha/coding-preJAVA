package com.ex0129;

public class Ex02 {

	public static void main(String[] args) {
		Test2 t = new Test2();
		t.print();

	}

}
class Test2{
	private int x, y;
	
	public Test2() { 
		x=10; y=5;
	}
	public void print() {
		System.out.println(x+","+y);
	}
}
