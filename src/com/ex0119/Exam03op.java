package com.ex0119;

import java.util.Scanner;


public class Exam03op {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("�ݾ� �Է�:");
		int a=sc.nextInt();
		System.out.printf("�������� %d��\n�ϸ����� %d��\n��õ���� %d��\n"
				+ "��õ���� %d��\n������� %d��\n�Ϲ���� %d��\n"
				+ "���ʿ��� %d��\n�ʿ��� %d��\n������ %d��\n"
				+ "�Ͽ��� %d��", a/50000, a%50000/10000, a%10000/5000,
				a%5000/1000, a%1000/500, a%500/100, a%100/50,
				a%50/10, a%10/5, a%5);
		
		sc.close();

	}

}
