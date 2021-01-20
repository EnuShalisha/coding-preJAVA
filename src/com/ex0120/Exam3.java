package com.ex0120;

public class Exam3 {

	public static void main(String[] args) {
		char a='A';
		char b='A'+10;
		System.out.println(a+","+b);
		
		b='A'+3; // 리터럴+리터럴 -> 형변환 x
		System.out.println(b);
		//b=a+3; 변수+리터럴 -> int형으로 자동변환도 아니고, 그냥 컴파일 오류
		b=(char)(a+3);
		System.out.println(b);
		
		double x=15/2; // 15와 2는 둘다 정수리터럴 -> 형변환 일어나지 않고 정수로 취급
		double y=15.0/2.0; // 둘다 더블형일때만 결과가 더블형태로
		System.out.println(x+" "+y);

	}

}
