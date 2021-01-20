package com.ex0120;

import java.util.Scanner;

public class Ex04if {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("수?");
		int a=sc.nextInt();
		String s;
		s="2와 3의 배수가 아님";
		if(a%2==0)
		{if(a%3==0) {
			s="2이면서 3의 배수임";
		}
		else {
			s="2의 배수임";
		}
		}
		else if(a%3==0) {
			s="3의 배수임";
		}
		System.out.println(s);
		
		sc.close();

	}

}
