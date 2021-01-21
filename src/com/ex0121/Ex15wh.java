package com.ex0121;

public class Ex15wh {

	public static void main(String[] args) {
		int dan=0; int n=0;
		while(dan<9) {
			dan++;
			System.out.printf("**%d단**\n", dan);
			n=0;
			while(n<9) {
				n++;
				System.out.printf("%d * %d = %d\n", dan, n, dan*n);
			}
			System.out.println();
		}

	}

}
