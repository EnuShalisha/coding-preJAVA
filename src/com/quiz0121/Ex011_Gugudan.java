package com.quiz0121;
import java.util.Scanner;

public class Ex011_Gugudan {
	public static void main(String[] args) {
/*
		정수(단)를 입력 받아 입력 받은 수의 구구단을 출력
*/
		Scanner sc=new Scanner(System.in);
		
		int dan;
		int s, n;
		
		System.out.print("단 ? ");
		dan=sc.nextInt();
		
		n=0;
		while(n<9) {
			n++;
			s=dan*n;
			System.out.printf("%d * %d = %d\n", dan, n, s);
			// System.out.println(dan + "*" + n + "= " + s);
		}
		
		sc.close();
	}
}
