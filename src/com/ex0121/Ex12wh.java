package com.ex0121;

public class Ex12wh {

	public static void main(String[] args) {
		int n, s;
		n=s=0;
		while(true) {
			n++;
			s+=n;
			if(n>=10)
				break;
		}
		System.out.println("결과: "+s);
	}

}
