package hw_0120;

import java.util.Scanner;

public class HW8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학번 ?");
		int a=sc.nextInt();
		System.out.println("이름 ?");
		String b=sc.next();
		System.out.println("중간고사 점수 ?");
		int c=sc.nextInt();
		System.out.println("기말고사 점수 ?");
		int d=sc.nextInt();
		System.out.println("결석횟수 ?");
		int p=sc.nextInt();
		System.out.println("레포트 점수 ?");
		int f=sc.nextInt();
		int e=0;
		if(p<6)
			{if(p<2) {
				e=100;}
			else if(p<4) {
				e=80;}
			else {
				e=60;}
			}
		int g=(int)(c*0.4+d*0.4+e*0.1+f*0.1);
		char h='F';
		if (g>=60) {
			if(g>=90) {
				h='A';}
			else if(g>=80) {
				h='B';}
			else if(g>=70) {
				h='C';}
			else {
				h='D';}
			}
		
		System.out.printf("학번    이름 중간고사 기말고사 출석점수 레포트 합산점수 학점\n %d  %s  %d  %d  %d  %d  %d  %c"
				, a, b, c, d, e, f, g, h);
	}

}
