package com.ex0203;

import java.util.Random;

public class Ex01ran {

	public static void main(String[] args) {
		Random rnd = new Random();
		int n;
		
		for(int i=1; i<=100; i++) {
			n=rnd.nextInt(100);
			System.out.printf("%5d", n);
			if(i%10==0)
				System.out.println();
		}

	}

}
