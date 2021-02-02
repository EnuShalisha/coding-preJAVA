package com.ex0129;

public class Ex06 {

	public static void main(String[] args) {
		Test6 t = new Test6(4);
		t.print(); // this 24 -> 4와 5가 옮겨지지 않음
	}

}

class Test6{
	private int x;
	private int y;
	
	public Test6() {
		System.out.println("인자 없는 생성자");
	}
	
	public Test6(int x) {
		//Test6(x, 5); 컴파일오류, 생성자는 일반 메소드처럼 호출 불가능.
		// 생성자는 객체를 생성할 때 new 다음에만 사용 가능
		
		this(x, 5); //다른 생성자를 주소 할당 없이 호출
		//한번만 가능하고 최상단으로 와야함
		//this 주소 24로 쭉 유지
		
		//new Test6(x, 5); // 얘는 this 주소 24
		//여기서 객체를 또만듬
		//그러므로 스택에서 더 위에 생김
		//x=int x, y=5이나 인자 두개 생성자 -> 인자 한개 생성자로 발생
		//또한 메모리를 하나 잡고 제거하지도 못함
		
		System.out.println("인자 한개 생성자");
	}
	
	public Test6(int x, int y) {
		System.out.println("인자 두개 생성자"); // 얘는 새 객체니까 this 주소 25
		this.x=x;
		this.y=y;
	}
	
	public void print() {
		System.out.println(x+","+y);
	}
	
	
}