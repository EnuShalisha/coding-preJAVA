package com.ex0121;

public class Ex07wh {

	public static void main(String[] args) {
		int n=1; int s=0; int cnt=0;
		while(n<100) {
			System.out.print(n+"\t");
			cnt++;
			if(cnt==5)
			{System.out.printf("\n");
			cnt=0;
			}
			s+=n;
			n+=2;
		}
		System.out.printf("\n1~100까지 홀수합은 %d입니다.", s);
	}
	

}
