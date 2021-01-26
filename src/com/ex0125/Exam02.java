package com.ex0125;

import java.util.Arrays;
import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("구매 개수? [1~5]");
		int n=0;
		do
			{n= sc.nextInt();}
		while(n<1||n>5);
		
		for(int i=1; i<=n; i++) {
			
			int number[] = new int[6];
			for(int l=0; l<number.length; l++) {
				number[l]=(int)(Math.random()*45)+1;
				for(int s=0; s<l; s++) {
					if(number[s]==number[l])
						{l--;
						break;}
				}
				/*System.out.print(number[l]+" ");*/
			}
			Arrays.sort(number);
			System.out.print(i+"번째 : ");
			for(int z:number) 
				System.out.print(z+" "); // number[z]가 아니라 그냥 z, 원소로 표현함
			System.out.println();
		
		}
			sc.close();
			
			/*int a[];
			// a[0]=10; a 정의 x, 컴파일 오류

			int a[]=null; // 메모리 할당 x, 주소가 null 
			a[0]=10; // nullpointerexception 런타임 오류*/
	}

}
