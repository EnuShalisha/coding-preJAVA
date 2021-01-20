package com.ex0120;

import java.util.Scanner;

public class Ex04if {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("수?");
		int a=sc.nextInt();
		String s;
		s="2와 3의 배수가 아님";
		/*if(a%2==0)
		{if(a%3==0) {
			s="2이면서 3의 배수임";
		}
		else {
			s="2의 배수임";
		}
		}
		else if(a%3==0) {
			s="3의 배수임";
		}*/
		if(a%2==0&&a%3==0) {
			s="2와 3의 배수";
		}else if(a%2==0) { // a%2==0&a%3==0은 안됨; 위의 a%2==0과 중복
			s="2의 배수";
		}else if(a%3==0) {
			s="3의 배수";
		}else {
			s="2도 3도 아님";
		}
		
		System.out.println(s);
		
		sc.close();

	}

}
