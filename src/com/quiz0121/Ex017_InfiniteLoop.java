package com.quiz0121;
public class Ex017_InfiniteLoop {
	public static void main(String[] args) {
/*
		1~10까지의 정수의 합을 출력 : 무한 루프(infinite loop), break 사용
*/
		int n, s;
		
		n=0;
		s=0;
		while(true) { // 무한 loop
			n++;
			s+=n;
			if(n==10) {
				break; // while 문을 빠져나감
			}
		}
		System.out.println("결과 : "+s); // 55
	}
}
