package com.ex0125;

public class Ex06 {

	public static void main(String[] args) {
		int cnt=0;
		long start=System.nanoTime();
		gogo:
		for(int i=2; i<=100; i++) {
			
			for(int j=2; j<=i/2; j++) { // 제곱근 메소드 가지고오면 반복횟수 훨씬 줄일 수 있어
				//원래 제곱근까지만 곱하면 되지만 그나마 /2로 범위를 줄임
				if(i%j==0) 
					continue gogo; // continue 넣으면 boolean 필요 없음
			}
			System.out.printf("%5d", i);
			cnt++;
			if(cnt%10==0) 
				System.out.println();
				}
		System.out.println();
		long end=System.nanoTime();
		end-=start;
		System.out.println(end);
			}
		
	}

