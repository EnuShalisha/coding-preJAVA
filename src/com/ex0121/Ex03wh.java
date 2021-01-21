package com.ex0121;
import java.util.Scanner;

public class Ex03wh {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("단[1~9] ? ");
		int d=sc.nextInt();
		int n=1;
		if(d<=9&&d>=1) {while(n<=9) {
			System.out.printf("%d * %d = %d\n", d,n,d*n);
			n++;
		}}
		else
			System.out.println("잘못 입력하셨습니다.");
		sc.close();
	}

}
