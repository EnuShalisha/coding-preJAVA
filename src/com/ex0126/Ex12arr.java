package com.ex0126;

import java.util.Arrays;
import java.util.Scanner;

public class Ex12arr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num[] = new int[10];
		for(int i=0; i<10; i++) {
			num[i]= (int)(Math.random()*20)+1;
			for(int j=0; j<i; j++) {
				if(num[i]==num[j])
					{i--;
					break;}
			}
				
		}
		int n;
		//int idx= -1;
		System.out.print("검색할 숫자는 ?");
		n=sc.nextInt();
		//이분검색
		Arrays.sort(num);
		System.out.println("전체 난수: ");
		for(int a:num)
			System.out.print(a+" ");
		System.out.println();
		
		int low=0, high=num.length-1, mid=-1;
		boolean b=false;
		while(low<=high) {
			mid=(low+high)/2;
			if(n==num[mid]) {
				b=true;
				break;
			}
			else if(n<num[mid]) 
				high=mid-1;
			else
				low=mid+1;
		}
		if(!b)
		
		/* 순차검색
		 	for(int i=0; i<10; i++) {
		
			if(n==num[i])
				{idx=i+1;
				break;} // 뒤에는 검색 종료
		}
		 
		if(idx==-1)*/
			System.out.println("존재하지 않음");
		else
			System.out.println("숫자"+n+"은 "+mid+"에 위치");
	sc.close();
	}

}
