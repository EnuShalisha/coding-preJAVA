package com.ex0121;

public class Ex01wh {

	public static void main(String[] args) {
		int s, n;
		/*s=0; n=0;
		while(n<100) {
			n+=2;
			s+=n;
			System.out.println(n);
		}
		System.out.println("결과: "+s);*/
		
		s=0; n=1;
		while(n<100) {
			s+=n;
			n+=2;
			System.out.println(n);
		}
		System.out.println("결과: "+s);
		
	}

}
