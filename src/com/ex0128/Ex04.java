package com.ex0128;

public class Ex04 {
	private int r;
	public double area() {
		return r*r*3.14;
	}
	public static void main(String[] args) {
		//r=10; 매인 메소드도 static임 - 인스턴스 접근 불가
		Ex04 ob = new Ex04();
		ob.r=10;
		double s=ob.area();
		System.out.println(s);
	}

}
