package com.ex0121;

public class Ex13wh {

	public static void main(String[] args) {
		int n, num;
		
		n=0;
		while(n<100) {
			num=(int)(Math.random()*100)+1; // 0~1 사이 난수, 중복 가능
			System.out.printf("%5d", num);
			n++;
			if(n%10==0) {
				System.out.println();
			}
		}

	}

}
