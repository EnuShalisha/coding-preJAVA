package com.ex0119;

import java.util.Scanner;

public class Exam04op {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주행거리: ");
		int a=sc.nextInt();
		System.out.println("시속: ");
		int b=sc.nextInt();
		double h, m;
		double s;
		double t;
		t=(double)a/b;
		System.out.printf("%.2f",t);
		h=(int)t;
		m=t*60%60;
		s=t*3600%60;
		System.out.printf("시: %f, 분: %f, 초: %f\n", h, m, s);
		sc.close();

	}

}
