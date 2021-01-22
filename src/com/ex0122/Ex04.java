package com.ex0122;

public class Ex04 {

	public static void main(String[] args) {
		int n;
		
		for(int i=1; i<=10; i++) {
			n=(int)(Math.random()*10)+1;
			System.out.print(n+" ");
			if(n==7)
				i--; // 한번 더 기회
		}
		System.out.println();
	}

}
