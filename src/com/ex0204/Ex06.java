package com.ex0204;

public class Ex06 {

	public static void main(String[] args) {
		Demo6 ob = new Demo6();
		ob.method(); // 슈퍼에서 켰는데 서브로 나오네
		//이 메소드는 Demo에서 실행돼서 당연히 Demo의 print를 호출한거로 봐야함

	}

}

class Test6{
	
	public void print() {
		// print(); //stack overflow error - 재귀호출
		System.out.println("super");
	}
	
	public void method() {
		print();
	}
}

class Demo6 extends Test6{
	public void print() {
		System.out.println("sub");
	}
}