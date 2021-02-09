package com.ex0208;

public class Ex04if {

	public static void main(String[] args) {
		//컴파일 오류 Test4.Demo4 td = new Test4(); 
		Test4 t = new Test4();
		
		//다른 ㅋ늘래스의 멤버 클래스 객체는 잘 생성하지 않음
		Test4.Demo4 td = t.new Demo4(); 
		td.sub();
	}

}

class Test4{
	

public class Demo4{
//	static int a=10;
	
	
	int c=30;
	public void sub() {
//		System.out.println(a+","+b+","+","+c;
	}
}
	public void write() {
		Demo4 dd=new Demo4();
		System.out.println(dd.c);
	}
	
	public void sample() {
		//로컬 클래스. 거의 안씀
		class User{
			int x=10;
		}
		User u = new User();
		System.out.println(u.x);
	}

}