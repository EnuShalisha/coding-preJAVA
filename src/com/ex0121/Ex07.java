package com.ex0121;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("년과 월 입력: ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		int d=0;
		
		switch(b)
			{case 1:case 3:case 5:case 7:case 8:case 10:case 12:
				d=31; break;
			case 4:case 6:case 9:case 11:
				d=30; break;
			case 2:d=28;
			if(a%4==0&&a%100!=0||a%400==0)
				d=29;}
		if(d!=0)
			System.out.printf("%d년 %d월의 마지막 날은 %d일입니다.\n"
					,a, b, d);
		else
			System.out.println("입력 오류입니다.");
		sc.close();
		}
	
	}

