package com.ex0225;

public class Ex02 {

	public static void main(String[] args) {
		Test2 tt=new Test2();
		tt.using();

	}

}

interface User2 {
	public void sub();
}

class Test2{
	int x=10;
	
	class Demo {
		int y=20;
		
		public void write() {
			int z=30;
			
			User2 u=() ->{
				System.out.println(this); // 여기서 this는 익명객체(람다객체)가 아니라 람다식을 구현한 클래스의 객체
				//즉,
				System.out.println(Demo.this);
				
				System.out.println(x);
				System.out.println(Test2.this.x); // this 앞에 어떤 객체를 받는건지 생략할 수 없는 케이스
				
				System.out.println(y);
				System.out.println(this.y);
				
				System.out.println(z);
			};
			//z=10; 에러, 람다에서 사용한 변수는 FINAL 속성
			//그러므로 z는 못바꿈
			u.sub();
		}
	}
	public void using() {
		Demo ob=new Demo();
		ob.write();
	}
}