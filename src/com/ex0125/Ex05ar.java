package com.ex0125;

public class Ex05ar {

	public static void main(String[] args) {
		int n;
		int cnt[] = new int[10];
		for(int i=1; i<=100; i++) {
			n=(int)(Math.random()*10)+1;
			cnt[n-1]++;
			System.out.printf("%5d", n);
			
			if(i%10==0)
			System.out.println();
		}
		System.out.println("---------");
		for(int i=0; i<10; i++) 
			System.out.println((i+1)+": "+cnt[i]);
		

	}

}
