package com.ex0120;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		//블라블라블라블라
		Scanner sc = new Scanner(System.in);
		int a; String b;
		System.out.println("연도? ");
		a=sc.nextInt();
		/*b=a%4==0?
				(a%100==0?
						(a%400==0?"윤년":"평년")
						:"윤년")
				:"평년";*/
		b=a%4==0&&a%100!=0||a%400==0?"윤년":"평년";
		System.out.printf("%d년은 %s이다.", a, b);
	}

}
