package com.ex0120;

import java.util.Scanner;

public class Ex02if {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.println("���� �Է�: ");
		int a=sc.nextInt();
		if(a%2==0) {
			s="¦��";
		}
		else {
			s="Ȧ��";
		}
		/*else if (a%2==1){
		 * s="Ȧ��";}
		 �̰ɷδ� ������ ����*/
		System.out.println(a+"->"+s);
		sc.close();
	}

}
