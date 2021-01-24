package com.quiz0121;
public class Quiz109_Fibonacci {
	public static void main(String[] args) {
/*		
		피보나치수열 1+1+2+3+5+8+13+21 합
*/
		int a=1, b=1, c;
        int s=2;
        
        int n=2;
        while(n<8) {
            c=a+b;
            s=s+c;
            a=b;
            b=c;
            n++;
        }
        System.out.println("결과 : "+s); // 54
	}
}
