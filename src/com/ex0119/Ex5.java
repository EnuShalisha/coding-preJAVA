package com.ex0119;

public class Ex5 {

	public static void main(String[] args) {
		float a;
		double b;
		int c;
		
		a=10; // a->int값을 float에 대입 -> 10.0
		
		//a=0.5;  0.5는 double형 리터럴 -> 에러
		b=0.5;
		
		a=0.5f; // float으로 전환 완료
		c=100;
		b=c; // int를 float에 대입은 가능
		//c=b;  float을 int에 대입 불가능

	}

}
