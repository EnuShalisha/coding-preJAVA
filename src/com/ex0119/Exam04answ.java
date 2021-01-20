package com.ex0119;

import java.util.Scanner;

public class Exam04answ {

			public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				System.out.println("주행거리: ");
				int a=sc.nextInt();
				System.out.println("시속: ");
				int b=sc.nextInt();
				double t, s;
				int h, m;
				t= (double) a / b * 3600;
				h=(int)(t/3600);
				t=t-(h*3600);
				m=(int)(t/60);
				s=t-(m*60);
				System.out.printf("%d시간, %d분, %.2f초", h, m, s);
				sc.close();
	}

}
