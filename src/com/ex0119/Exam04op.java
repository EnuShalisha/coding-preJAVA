package com.ex0119;

import java.util.Scanner;

public class Exam04op {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����Ÿ�: ");
		int a=sc.nextInt();
		System.out.println("�ü�: ");
		int b=sc.nextInt();
		double h, m;
		double s;
		double t;
		t=(double)a/b;
		System.out.printf("%.2f",t);
		h=(int)t;
		m=t*60%60;
		s=t*3600%60;
		System.out.printf("��: %f, ��: %f, ��: %f\n", h, m, s);
		sc.close();

	}

}
