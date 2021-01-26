package com.ex0125;

import java.util.Scanner;

public class Ex10ar {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int y, m, d;
		int tot, w;
		int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		do {
			System.out.println("년도 ? ");
			y=sc.nextInt();
		}while(y<1);
		
		days[1] = y%4==0&&y%100!=0||y%400==0? 29:28;
		tot=(y-1)*365+(y-1)/4-(y-1)/100+(y-1)/400;
		
		do {
			System.out.println("월? ");
			m=sc.nextInt();
		}while(m<1||m>12);
		for(int i=1; i<m; i++) // 1월부터 m월 전까지
			tot+=days[i-1]; // m월 전까지의 것을 m-1의 주소에서 찾음
		
		do {
			System.out.println("일? ");
			d=sc.nextInt();
		} while(d<1||d>days[m-1]);
		tot+=d;
		
		w=tot%7;
		
		String x[]= {"일", "월", "화", "수", "목", "금", "토"}; // w의 범위는 0:일요일부터 6:토요일까지
		
		System.out.printf("\t%d년 %d월 %d일은 %s요일입니다.\n", 
				y, m, d, x[w]); // 만약 w-1일 경우 -1에서 런타임 에러 발생
		
		
		
		System.out.println();
		/*System.out.println("총 일수는: "+tot);*/
		
		sc.close();	

	}

}
