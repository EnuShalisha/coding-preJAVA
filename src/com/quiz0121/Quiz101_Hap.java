package com.quiz0121;
import java.util.Scanner;

public class Quiz101_Hap {
	public static void main(String[] args) {
/*		
		정수를 입력 받아 1부터 입력 받은 수까지의 합, 짝수 합, 홀수 합
*/
		Scanner sc=new Scanner(System.in);

		int input;
		System.out.print("수 ? ");
		input = sc.nextInt();

		int n, s, o, e;
		n=s=o=e=0;
		while(n < input) {
			n++;
			s+=n;
			if(n%2==0)
				e+=n;
			else
				o+=n;
		}

		System.out.println("1~"+input+" 까지 합 = " + s);
		System.out.println("1~"+input+" 까지 짝수 합 = " + e);
		System.out.println("1~"+input+" 까지 홀수 합 = " + o);
		
		sc.close();
	}
}
