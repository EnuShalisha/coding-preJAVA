package com.ex0125;

import java.util.Scanner;

public class Ex12ar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("5개 점수 입력: ");
		int score[]=new int[5];
		int max, min, tot=0;
		int temp=0;
		for(int i=0; i<score.length; i++) {
			do {
				score[i]=sc.nextInt();
			}while(score[i]<0||score[i]>100);
			tot+=score[i];
			/*score[i]=sc.nextInt();
			if(score[i]<0||score[i]>100) {
				i--;
				continue;
			}*/
		}
		max=min=score[0]; // 이니셜라이즈 필요
		for(int i=1; i<score.length; i++) {
			/*if(i==0) {
				max=score[i]; min=score[i];
			}*/
			if(max<score[i])
				max=score[i];
			else if(min>score[i]) 
				// 어차피 최대값으로 정해졌으면 if로 넣으면 불필요한 연산
				min=score[i];
			//tot+=score[i];
		}
		
		System.out.println("최소 최대 제외 합:"+(tot-min-max));
		/*for(int i=0; i<score.length; i++) {
			if(i==0)
				continue;
			if(score[i]<score[i-1])
				{temp=score[i-1];
				score[i-1]=score[i];
				score[i]=temp;}
		}
		System.out.println("최소 최대 제외 합:"+(score[1]+score[2]+score[3]));*/
	}

}
