package com.ex0129;

public class Ex04 {

	public static void main(String[] args) {
		Test4 t = new Test4();
		t.print();

	}

}

class Test4{
	private int x;
	public void Test4() { // 리턴타입 void가 존재 -> 얘는 생성자가 아님
		x=10; 
		
	}
	public void print() {
		System.out.println(x);
	}
}