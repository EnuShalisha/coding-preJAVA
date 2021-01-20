package com.ex0119;

public class Ex4 {
//더블형 써야하는 이유?
	public static void main(String[] args) {
		int i1=200000000;
		int i2=200000050;
		float f1=200000000;
		float f2=200000050;
		double d1=200000000;
		double d2=200000050;
		System.out.println(i1+","+i2);
		System.out.println(f1+","+f2);
		System.out.println(d1+","+d2+"\n");
		
		System.out.printf("%d, %d\n", i1, i2);
		System.out.printf("%2f, %2f\n", f1, f2);
		System.out.printf("%2f, %2f\n", d1, d2);
	}

}
