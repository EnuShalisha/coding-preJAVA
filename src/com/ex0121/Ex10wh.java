package com.ex0121;

public class Ex10wh {

	public static void main(String[] args) {
		int s, n;
		s=n=0;
		while(n<10) {
			n++;
			s+=n;
		}
		System.out.println("결과: "+s);
		
		s=n=0;
		do {
			n++;
			s+=n;
		} while(n<10);
		System.out.println("결과: "+s);
	}

}
