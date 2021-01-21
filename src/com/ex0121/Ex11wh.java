package com.ex0121;

import java.util.Scanner;

public class Ex11wh {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, s;
		s=1;
		do {System.out.println("수 입력[1-9]: ");
		a=sc.nextInt();
		}while(a<1||a>9); // ~를 입력받지 않을 때 까지
		while(s<10) {
			System.out.printf("%d * %d = %d\n", a, s, a*s);
			s++;
		}
		sc.close();
	}

}
