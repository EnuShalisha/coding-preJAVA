package com.ex0202;

import java.util.Calendar;
import java.util.Scanner;

public class Ex03cal {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		int y,m;
		
		System.out.print("년도 ?");
		y=sc.nextInt();
		do {
			System.out.println("월? ");
			m=sc.nextInt();
		} while(m<1||m>12);
		
		cal.set(y, m-1, 1);
		
		int w= cal.get(Calendar.DAY_OF_WEEK);
		
		int lastDay=cal.getActualMaximum(Calendar.DATE);
		
		System.out.println("\t"+y+"년 "+m+"월");
		System.out.println("일   월   화   수   목   금   토");
		System.out.println("-------------------");
		
		for(int i=1; i<w; i++) {
			System.out.print("    ");
		}
		
		for(int i=1; i<=lastDay; i++) {
			System.out.printf("%4d", i);
			w++;
			if(w%7==1)
				System.out.println();
		}
			if(w%7!=1)
				System.out.println();
			System.out.println("-------------------------");
		
		
		sc.close();

	}

}
