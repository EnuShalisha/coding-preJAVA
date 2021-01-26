package com.ex0125;

public class Ex02 {

	public static void main(String[] args) {
		int n=0, s=0;
		while(n<100) {
			n++;
			if(n%2==0)
				continue; // switch case에선 사용 불가능
			s+=n; // continue를 if 밖에 쓸경우 본 코드 실행 불가 -> 컴파일 에러
		}
	System.out.println("결과:"+s);
	}

}
