package com.ex0125;

import java.util.Scanner;

public class Ex02ar {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a[] = new int [5];
		int tot=0; double ave;
		
		System.out.println("5�� ���� �Է�:");
		for(int i=0; i<a.length; i++) {
			a[i]=sc.nextInt();
			tot+=a[i];
		}
		ave=(double)(tot)/a.length;
		System.out.println("��� :"+ave);
		System.out.println("����\t����");
		for (int i=0; i<a.length; i++) 
			System.out.println(a[i]+"\t"+(a[i]-ave));
		
		sc.close();

	}

}
