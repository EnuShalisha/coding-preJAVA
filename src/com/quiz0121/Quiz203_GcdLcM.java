package com.quiz0121;
import java.util.Scanner;

public class Quiz203_GcdLcM {
	public static void main(String[] args) {
/*		
		두정수를 입력 받아 입력 받은 정수의 최대공약수 및 최소공배수를 구하는 프로그램
*/		
		Scanner sc=new Scanner(System.in);

		int num1, num2, a, b, lcm;
		System.out.print("두수 ? ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		// 나머지를 이용한 최대공약수 구하기
		a=num1;
		b=num2;
		int mod = a % b;
	    while(mod > 0) {
	    	a = b;
	    	b = mod;
	        mod = a % b;
	    }
		System.out.println("GCD(최대공약수) : "+b);
		
/*	
		// a>b일 경우 a=a-b를, a<b일 경우 b=b-a를 a=b가 될때까지 반복하면 그 수가 최대공약수
		a=num1;
		b=num2;
		while(a != b) {
            if(a>b)
                a=a-b;
            else
                b=b-a;
        }
        System.out.println("GCD(최대공약수) : "+a);
*/
		
		lcm = (num1*num2)/b;
		System.out.println("LCM(최소공배수) : "+lcm);
        
        sc.close();
	}
}
