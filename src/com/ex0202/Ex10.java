package com.ex0202;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s;
		int count=0;
		
		//이름을 입력받아 입력받은 이름 중 김씨 성 가진 사람 수 출력
		//단 입력 받은 이름이 end이면 종료
		
		while(true) {
			System.out.println("이름 입력");
			s=sc.next();
			if(s.startsWith("김"))
				count++;
			if(s.equals("end")) 
				break;
			}
	System.out.println("김씨 인원수: "+count);
		sc.close();	
	}
	
	}


