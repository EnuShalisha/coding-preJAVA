package com.ex0121;

import java.util.Scanner;

public class Ex14wh {

	public static void main(String[] args) {
		int n, num, cnt;
		num=(int)(Math.random()*100)+1;
		n=0; cnt=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("알아맞춰보세요");
		while(true) {
			n=sc.nextInt();
			cnt++;
			if(n==num)
				break;
			else if(num<n) 
				System.out.println("다운");
			else System.out.println("업");
			System.out.println("킹받죠?");
	}
		System.out.println("몇번만에?: "+cnt);
		sc.close();

}}
