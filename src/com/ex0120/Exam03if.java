package com.ex0120;

import java.util.Scanner;

public class Exam03if {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է��ϱ�: ");
		int a=sc.nextInt();
		String p;
		/*if (a>=60) {
			if(a>=70) {
				if(a>=80) {
					if(a>=90) {
							p="��";
							}
					else {p="��";
					}}
				else {p="��";
				}}
		else {p="��";
		}}
		else if(a>=0) {p="��";}
		else {p="�Է� ����";}*/
		if(a>=00 && a<=100) {
			if(a>=90)
				p="��";
			else if(a>=80)
				p="��";
			else if(a>=70)
				p="��";
			else if(a>=60)
				p="��";
			else
				p="��";
		}
		else {
			p="�Է� ����";
		}
	 System.out.printf("������ %s", p);
	 sc.close();
}
}