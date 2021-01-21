package com.ex0121;

public class Ex04wh {

	public static void main(String[] args) {
		int a, n;
		a=0; n=0;
		while(a<100) {
			a++;
			n+=a;
			if(a%10==0)
				System.out.printf("1~%d까지의 합은 %d\n", a, n);
		}
		System.out.println(n);
	}

}
