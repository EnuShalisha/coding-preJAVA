package com.ex0127;

public class Ex03 {

	public static void main(String[] args) {
		T03 t1 = new T03();
		int a= Integer.parseInt(args[0]);
		System.out.println(t1.hap(a));

	}

}

class T03{
	public int hap(int n) { // 이걸 메소드 시그니처라고도 함(메소드 이름+매개변수)
		int s=0;
		for(int i=1; i<=n; i++)
			s+=i;
		return s; // 메소드와 동일한(또는 하위) 자료형이어야함
	}
	
}
