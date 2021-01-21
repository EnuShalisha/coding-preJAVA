package com.ex0121;

public class Ex09wh {

	public static void main(String[] args) {
		int n=10;
		while(n<10)
			{n++;
			System.out.println("안: "+n);
			}
		System.out.println("밖: "+n);
		System.out.println("--------------");
		
		n=10;
		do {
			n++;
			System.out.println("안: "+n);
		} while(n<10);
		System.out.println("밖 :"+n);
}
	}
