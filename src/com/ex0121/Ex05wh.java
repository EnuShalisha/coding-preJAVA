package com.ex0121;

public class Ex05wh {
	
	public static void main(String[] args) {
		int a, n, s;
		a=1; n=1; s=0;
		while(a<10) {
			a++;
			n*=a;
			
			System.out.printf("1~%d까지의 곱은 %d\n", a, n);
		}
		System.out.println(n);
		
		/*while(a<=10) {
			n+=a;
			s+=n;
			System.out.println(n);
			a++;
		}
		System.out.println(s);*/
	}

}
