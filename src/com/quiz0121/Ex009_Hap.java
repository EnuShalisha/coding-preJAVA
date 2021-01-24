package com.quiz0121;
import java.util.Scanner;

public class Ex009_Hap {
	public static void main(String[] args) {
/*
		정수를 입력 받아 1부터 입력 받은 수까지의 합
*/
		Scanner sc=new Scanner(System.in);
		
		int num;
		int s, n;
		
		System.out.print("정수 ? ");
		num=sc.nextInt();
		
		s=n=0;
		while(n<num) {
			n++;
			s+=n;
		}
		System.out.println("결과 : "+s);
		
		sc.close();
	}
}
