package com.quiz0121;
public class Ex015_Odd5 {
	public static void main(String[] args) {
/*
		1~100까지 수중 홀수를 한 줄에 5개씩 출력하고 마지막에 홀수 합을 출력하는 프로그램
*/
		int n, s, cnt;
		
		n=1;
		s=0;
		cnt=0;
		while(n<=100) {
			s+=n;
			System.out.print(n+"\t");
			cnt++;
			if(cnt%5==0) {
				System.out.println();
			}
			
			n+=2;
		}
		System.out.println("결과 : "+s);
		
	}
}
