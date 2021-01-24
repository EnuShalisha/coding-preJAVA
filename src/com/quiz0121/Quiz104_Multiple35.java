package com.quiz0121;
public class Quiz104_Multiple35 {
	public static void main(String[] args) {
/*		
		1~100까지 수중 3 또는 5의 배수 합과 평균
*/
		int n, s, cnt;
		
		n=s=cnt=0;
		while(n<100) {
			n++;
			if(n%3==0||n%5==0) {
				// System.out.print(n+"\t");
				s+=n;
				cnt++;
			}
		}
		
		System.out.println("합 : "+s);
		System.out.println("평균 : "+(s/cnt));
	}
}
