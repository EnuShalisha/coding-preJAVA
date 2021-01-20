package com.ex0120;

import java.util.Scanner;

public class Exam03if {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수 입력하기: ");
		int a=sc.nextInt();
		String p;
		/*if (a>=60) {
			if(a>=70) {
				if(a>=80) {
					if(a>=90) {
							p="수";
							}
					else {p="우";
					}}
				else {p="미";
				}}
		else {p="양";
		}}
		else if(a>=0) {p="가";}
		else {p="입력 오류";}*/
		if(a>=00 && a<=100) {
			if(a>=90)
				p="수";
			else if(a>=80)
				p="우";
			else if(a>=70)
				p="미";
			else if(a>=60)
				p="양";
			else
				p="가";
		}
		else {
			p="입력 오류";
		}
	 System.out.printf("점수는 %s", p);
	 sc.close();
}
}