package com.ex0125;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=1, s=0, num;
		System.out.println("5개의 홀수 입력:");
		while(n<=5) {
			num=sc.nextInt();
			if(num%2==0 || num<=0)
				continue;
			s+=num;
			n++;
		}
		System.out.println("합: "+s);
		sc.close();
	}

}
