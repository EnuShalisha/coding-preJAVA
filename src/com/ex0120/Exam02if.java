package com.ex0120;

import java.util.Scanner;

public class Exam02if {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("세 수:");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		if (a<b) {
			if(b<c) {
				/*if(a<c)*/ {System.out.printf("순서는 %d,%d,%d",a,b,c);}
				/*else {System.out.printf("순서는 %d,%d,%d",c,a,b);}*/
				}
			else {if(a<c) {System.out.printf("순서는 %d,%d,%d",a,c,b);}
				else {System.out.printf("순서는 %d,%d,%d",c,a,b);}
				}
			}
			else {if(b<c) {
				if(a<c) {System.out.printf("순서는 %d,%d,%d",b,a,c);}
				else {System.out.printf("순서는 %d,%d,%d",b,c,a);}}
			else /*{if(a<c) {System.out.printf("순서는 %d,%d,%d",c,b,a);}
			else */{System.out.printf("순서는 %d,%d,%d",c,b,a);}
			}
			
}}
					