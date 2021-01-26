package com.ex0125;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n;
		double num, s=0;
		System.out.println("5개의 실수 입력:");
		for(n=0; n<5; n++) { // while 인수를 ++로 쓸 경우와 유사
			//배열 메모리에 맞도록 0부터 시작, 끝을 등호 안넣고 5로 넣으면 5개 값 주는걸로 가독성 상승
			num=sc.nextDouble();
			if(num<=0)
				{n--;
				continue;}
			s+=num;
			//n++;을 여기에 붙여도 무방
		}
		System.out.println("합: "+s);
		sc.close();
	}

	}

