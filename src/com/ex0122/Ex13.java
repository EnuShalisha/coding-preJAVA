package com.ex0122;

import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int user, com;
		
		while(true) {
			do {
				System.out.print("1. 가위 2. 바위 3. 보 4. 종료");
				user=sc.nextInt();
			} while(user<1||user>4);
			
			if(user==4) break;
			
			com=(int) (Math.random()*3)+1;
			System.out.println("당신:"+(user==1?"가위":user==2?"바위":"보"));
			System.out.println("컴퓨터:"+(com==1?"가위":com==2?"바위":"보"));
		
			/*if((user==2&&com==1)||(user==3&&com==2)||(user==1&&com==3))
				System.out.println("당신이 이겼습니다.");
			else if((user==2&&com==2)||(user==3&&com==3)||(user==1&&com==1))
				System.out.println("비겼습니다.");
			else
				System.out.println("컴퓨터가 이겼습니다.");*/
			if(user==com) // 가장 간단하게 짤수있는 경우
				System.out.println("비겼습니다.");
			else if((user==2&&com==1)||(user==3&&com==2)||(user==1&&com==3))
				//=user-com=1 || user-com=-2
				System.out.println("당신이 이겼습니다.");
			else
				System.out.println("컴퓨터가 이겼습니다.");
		}
		sc.close();
	}

}
