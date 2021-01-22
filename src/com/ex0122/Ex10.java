package com.ex0122;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, s, ch;
		
		while(true) {
			do {
				System.out.print("1.합 2.짝수합 3.홀수합 4.종료 =>");
				ch=sc.nextInt();
			} while(ch<1||ch>4);
		if(ch==4) break;
		
		System.out.println("원하는 수?");
		n=sc.nextInt();
		
		s=0;
		/*if(ch==1) {
			for(int i=1; i<=n; i++)
				s+=i;
			System.out.println("합: "+s);
		}else if(ch==2) {
			for(int i=2; i<=n; i+=2) 
				s+=i;
			System.out.println("짝수합: "+s);
		}else if(ch==3) {
			for(int i=1; i<=n; i+=2)
				s+=i;
			System.out.println("홀수합:" +s);*/
		int e=0, f=0; String g="합";
		/*if(ch==1)
			{e=1; f=1; g="합";}
		else if(ch==2)
			{e=2; f=2; g="홀수합";}
		else if(ch==3)
			{e=1; f=2; g="짝수합";}*/
		switch(ch) {
		case 1:e=1;f=1;g="합"; break;
		case 2:e=2;f=2;g="짝수합"; break;
		default:e=1;f=2;g="홀수합"; break;
		}
		for(int i=e; i<=n; i+=f)
			s+=i;
		System.out.println(g+": "+s);
			
		}
		sc.close();
	}

}
