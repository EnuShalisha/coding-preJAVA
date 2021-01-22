package com.ex0122;

public class Ex02 {
	public static void main(String[] args) {
		//1에서 10까지 합
		
		/*int s, n;
		for(n=1, s=0; n<=10; s+=n, n++)
			;
		System.out.println("합"+s);*/
		 
		int n, s;
		n=s=0;
		for(; ;) { //무한루프
			n++;
			s+=n;
			if(n>=10) break;
		}
		System.out.println(s);
	}

}
