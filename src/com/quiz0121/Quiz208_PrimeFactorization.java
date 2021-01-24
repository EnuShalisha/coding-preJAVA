package com.quiz0121;
import java.util.Scanner;

public class Quiz208_PrimeFactorization {
	public static void main(String[] args) {
/*		
	 	2이상의 정수를 입력 받아 소인수 분해하여 출력 하는 프로그램
*/	 	
		Scanner sc = new Scanner(System.in);

		int num;
		int p, n;
		
		do {
			System.out.print("정수 ? ");
			num=sc.nextInt();
		} while(num<2);
		
		System.out.print(num+" = ");
		
		p=2;
		n=num;
		while(n!=1) {
			if(n%p==0) {
				if(n!=num) {
					System.out.print("*");	
				}
				System.out.print(p);
				
				n=n/p;
			} else {
				p++;
			}
		}
		
		System.out.println();
		
		sc.close();
	}
}
