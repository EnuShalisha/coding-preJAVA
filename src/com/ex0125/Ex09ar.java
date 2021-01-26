package com.ex0125;

import java.util.Scanner;

public class Ex09ar {

	public static void main(String[] args) {
		/*1.1.1~2021.7.1 날의 수
		 * 2021을 y라 하면
		 * days=(y-1)*365+(y-1)/4-(y-1)/100+(y-1)/400
		 * 까지 하면 2020.12.31까지 계산
		 * 1~6월(m으로 함) 날수 = 31*3+28*1+30*2
		 * +1
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		
		int y, m;
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
		
		tot++;
		w=tot%7;
		
		System.out.printf("\t%d년 %d월\n", y, m);
		System.out.println("-----------------------------");
		System.out.println("   일  월   화  수   목  금   토");
		System.out.println("-----------------------------");
		
		for(int i=1; i<=w; i++) 
			System.out.print("    ");
		for(int i=1; i<=days[m-1]; i++) {
			System.out.printf("%4d", i);
			w++;
			if(w%7==0) {
				System.out.println();
			}
		}
		System.out.println();
		/*System.out.println("총 일수는: "+tot);*/
		
		sc.close();	
	}
		
		
		 

	}

