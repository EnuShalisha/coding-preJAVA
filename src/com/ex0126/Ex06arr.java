package com.ex0126;

import java.util.Scanner;

public class Ex06arr {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		String [] name = new String[5];
		int score[][] = new int[5][3];
		int tot[]=new int[5];
		int rank[]= {1, 1, 1, 1, 1}; // 1등은 무조건 있기때문에 1등을 기본값으로, 5등은 공동 4등이 있을경우 없음
		//점수 간의 비교로 석차를 1씩 더해줌
		
		String subject[]= {"국어", "영어", "수학"};
		
		for(int i=0; i<name.length; i++) {
			System.out.print((i+1)+"번째 이름? ");
			name[i]=sc.next();
			for(int j=0; j<score[i].length; j++) {
				System.out.print(subject[j]+"?");
				score[i][j]=sc.nextInt();
				tot[i]+=score[i][j];
			}
		}
		
	for(int i=0; i<rank.length; i++) {
		for(int j=i+1; j<rank.length; j++)
			if (tot[i]<tot[j])
				rank[i]+=1;
			else if(tot[i]>tot[j])
				rank[j]+=1;
	}
		
		System.out.println("\n이름\t국어\t영어\t수학\t총점\t평균\t석차");
		for(int i=0; i<name.length; i++) {
			System.out.print(name[i]+"\t");
			for(int j=0; j<score[i].length; j++) 
				System.out.print(score[i][j]+"\t");
		System.out.print(tot[i]+"\t");
		System.out.print(tot[i]/3+"\t");
		System.out.println(rank[i]);
		}
		sc.close();
	}

}
