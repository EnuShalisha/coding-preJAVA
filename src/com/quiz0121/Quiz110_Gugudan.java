package com.quiz0121;
public class Quiz110_Gugudan {
	public static void main(String[] args) {
/*		
		가로 출력 구구단
*/
		int dan, n;
		
		n=0;
		while(n < 9) {
			n++;
			
			dan=2;
			while(dan <= 9) {
				System.out.printf("%d*%d=%2d  ", dan, n, dan*n);
				dan++;
			}
			System.out.println();
		}
	}
}
