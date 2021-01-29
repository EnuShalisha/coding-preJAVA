package com.ex0128;

public class Ex07 {

	public static void main(String[] args) {
		Test7 t = new Test7();
		int s = t.sum(10);
		System.out.println(s);
		t.print(3);

	}

}

class Test7{
	public void print(int n) {
		System.out.println("start:"+n);
		if(n>1) {
			print(n-1);
			print(n-1);
		}
		System.out.println("end:"+n);
	}
	
	public int sum(int n) {
		return n>1 ? n+sum(n-1) : 1; // 종료조건을 사용해야 런타임에러 x
	} 
	
	public int sum2(int n) {
		int s=0;
		for(int i=1; i<=n; i++)
			s+=i;
		return s; 
	}
}