package com.ex0125;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		String a[] = {"������", "��", "��", "����", "��", "��", "ȣ����", "�䳢", "��", "��", "��", "��"};
		Scanner sc= new Scanner(System.in);
		System.out.println("���� �Է�: ");
		int y=sc.nextInt();
		int n=y%12;
		System.out.printf("%d���� ��� %s���Դϴ�.", y, a[n]);
		sc.close();
	}

	}


