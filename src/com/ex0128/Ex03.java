package com.ex0128;

public class Ex03 {

	public static void main(String[] args) {
		// Test3 t1, t2, t3, t4, t5 = new Test3();
		Test3[] tt= new Test3[5]; // Test3 자료형 객체 5개를 만들어라 - 널로 초기화
		// 이 상태로는 생성자 생성이 안댐
		//각 객체에 메모리 할당이 안된 상태
		//System.out.println(tt[0].a);
		for(int i=0; i<tt.length; i++) {
			tt[i]=new Test3();
		}
		System.out.println(tt[0].a);
		
		tt[4].a=5;
		System.out.println(tt[0].a+","+tt[4].a);
		tt[3]=null; // 초기화, 인스턴스 종료
		// System.out.println(tt[3].a); 런타임 오류
		
	}

}

class Test3{
	int a=10;
	int b;
	public void print() {
		System.out.println(a+","+b);
	}
}