package com.ex0119;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.print("������");
		a=sc.nextInt();
		double b,c;
		b=a*a*Math.PI; // math.PI�� double��
		c=2*a*Math.PI;
		System.out.printf("����: %.2f\n", b); // float ���´� ��ºο��� ����
		System.out.printf("�ѷ�: %.2f\n", c);

	}

}
