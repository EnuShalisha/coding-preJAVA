package com.ex0125;

public class Ex11ar {

	public static void main(String[] args) {
		int money=4380;
		int g;
		int a[]= {500, 100, 50, 10, 5, 1};
		
		System.out.println("동전\t개수");
		for(int n:a) {
			System.out.println(n+"\t"+money/n);
			money%=n;
		}
		/*for(int i=0; i<6; i++) {
			g=money/a[i];
			money-=g*a[i];
			a[i]=g;
		}
		System.out.printf("500원권 %d개 100원권 %d개 50원권 %d개\n 10원권 %d개 5원권 %d개 1원권 %d개"
				, a[0], a[1], a[2], a[3], a[4], a[5]);*/
	}

}
