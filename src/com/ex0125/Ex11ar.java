package com.ex0125;

public class Ex11ar {

	public static void main(String[] args) {
		int money=4380;
		int g;
		int a[]= {500, 100, 50, 10, 5, 1};
		
		System.out.println("����\t����");
		for(int n:a) {
			System.out.println(n+"\t"+money/n);
			money%=n;
		}
		/*for(int i=0; i<6; i++) {
			g=money/a[i];
			money-=g*a[i];
			a[i]=g;
		}
		System.out.printf("500���� %d�� 100���� %d�� 50���� %d��\n 10���� %d�� 5���� %d�� 1���� %d��"
				, a[0], a[1], a[2], a[3], a[4], a[5]);*/
	}

}
