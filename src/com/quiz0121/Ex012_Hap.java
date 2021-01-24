package com.quiz0121;
public class Ex012_Hap {
	public static void main(String[] args) {
/*
		1~100까지의 합을 구하는 프로그램을 작성하되 수가 10의 배수가 될 때마다 합을 출력
*/
		int s, n;
		
		s=n=0;
		while(n<100) {
			n++;
			s+=n;
			if(n%10==0)
				System.out.println("1~"+n+"까지 합 : " + s);
		}
	}
}
