package com.ex0208;

public class Ex01if {

	public static void main(String[] args) {
		Demo1 d = new Imp1();
		int a;
		a=Demo1.sum(10);
		d.write(a);
		
		a=d.max(10, 5);
		System.out.println(a);

	}

}

interface Demo1 {
	public void write(int n);
	public static int sum(int n){
		int s=0;
		for(int i=1; i<=n; i++) {
			s+=i;
		}
		return s;
	}
	public default int max(int m, int n) {
		return m>n? m:n;
	}
}

class Imp1 implements Demo1 {

	@Override
	public void write(int n) {
		System.out.println("결과: "+n);
		
	}
	
	
}