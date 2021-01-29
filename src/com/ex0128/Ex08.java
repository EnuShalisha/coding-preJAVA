package com.ex0128;

public class Ex08 {

	public static void main(String[] args) {
		Test8 ob = new Test8();
		double s= ob.pow2(2, -10);
		System.out.println(s);

	}

}

class Test8 {
	public int pow(int a, int b) {
		return b>=1? a*pow(a, b-1) : 1;
	}
	
	public double pow2(int a, int b) {
		if(b>=0)
			{return b>0? a*pow2(a, b-1) : 1;}
		else
		return 1.0/a*pow2(a, b+1); // 왜 1.0일까? ㅎㅎ
		
	}
}