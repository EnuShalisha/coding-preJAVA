package com.ex0120;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		//���������
		Scanner sc = new Scanner(System.in);
		int a; String b;
		System.out.println("����? ");
		a=sc.nextInt();
		/*b=a%4==0?
				(a%100==0?
						(a%400==0?"����":"���")
						:"����")
				:"���";*/
		b=a%4==0&&a%100!=0||a%400==0?"����":"���";
		System.out.printf("%d���� %s�̴�.", a, b);
	}

}
