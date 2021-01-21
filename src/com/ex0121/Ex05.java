package com.ex0121;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수 입력: ");
		int n=sc.nextInt();
		char g;
		switch(n/10){
		case 10:
		case 9: g='A'; break;
		case 8: g='B'; break;
		case 7: g='C'; break;
		case 6: g='D'; break;
		case 5:case 4:case 3:case 2:case 1:case 0: g='F'; break;
		default: g='-'; // 항상 g값이 존재하도록 만들어서 pirntf의 컴파일 오류 발생 x
		}
		System.out.printf("점수: %d 판정: %c", n, g);
		sc.close();

	}

}
