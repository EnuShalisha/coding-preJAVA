package com.quiz0121;
public class Quiz108_Hap20 {
	public static void main(String[] args) {
/*		
		1+2+4+7+11 ... 의 20번째 항까지의 합
*/
		int s = 0, t = 1, n = 0;

		while (n<20) {
			s += t;
			n++;
			t += n;
		}
		System.out.println("결과 : "+s); // 1350
	}
}
