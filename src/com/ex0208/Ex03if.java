package com.ex0208;

public class Ex03if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		static int a=10;
		int b=20;
		
		Test3.Demo3 td = new Test3.Demo3();
		td.sub();
	}

}

class Test3{
	static int a=10;
	int b;
	
	public void write() {
		
	}
	
	//중첩클래스 // static 선언 가능
	//다른클래스에서 단독으로 객쳇애성 가능
	//컴파일하면 TEst3$Demo3.class 파일 생성
	public static class Demo3{
		int c=30;
				public void sub() {
			//System.out.println(b);컴파일 오류
					System.out.println(a+","+c);
					
					Test3 t= new Test3();
					System.out.println(t.a);
		}
		
	}
}
