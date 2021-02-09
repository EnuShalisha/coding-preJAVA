package com.ex0209;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int ch;
		while(true) {
		try {
			
				do {
					System.out.print("1. 입력 2. 출력 3. 종료 ->");
					ch=sc.nextInt();
				} while(ch<1||ch>3);
				
				if(ch==3) break;
				
				switch(ch) {
				case 1: System.out.println("입력..."); break;
				case 2: System.out.println("출력..."); break;
				}
			}
		 catch (InputMismatchException e) {
			System.out.println("숫자만 가능"); // inputmismatch는 getmessage 값이 null이므로 출력하려면 print로
			sc.nextLine();//엔터를 읽어들여서 버려야한다고 나머지 안버려진다고
		}
		}
		
		
		System.out.println("end");
		sc.close();

	}

}
