package com.ex0122;

public class Ex05 {

	public static void main(String[] args) {
		for(int i=2; i<=9; i++) {
			System.out.println(i+"단 ");
			for(int j=1; j<=9; j++) {
				System.out.printf("%d*%d = *d\n", i, j, i*j);
			}
		}System.out.println("----");

	}

}
