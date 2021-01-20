package com.ex0120;

import java.util.Scanner;

public class Ex02if {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.println("정수 입력: ");
		int a=sc.nextInt();
		if(a%2==0) {
			s="짝수";
		}
		else {
			s="홀수";
		}
		/*else if (a%2==1){
		 * s="홀수";}
		 이걸로는 컴파일 에러*/
		System.out.println(a+"->"+s);
		sc.close();
	}

}
