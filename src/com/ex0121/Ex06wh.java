package com.ex0121;

public class Ex06wh {

	public static void main(String[] args) {
		int a=1,b=2; double c=0;
		while(b<=10) {
			c+=(double)a/b;
			a++;
			b++;
			System.out.printf("%.2f\n", c);
		}
		
	}

}
