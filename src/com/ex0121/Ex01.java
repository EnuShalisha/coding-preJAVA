package com.ex0121;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		String name, tel, birth;
		int age;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름? ");
		name=sc.nextLine();
		//메소드 next vs nextLine
		//공백입력 불가능 vs 중간 입력 가능
		//기본적으로 다이렉트 입력형식이 아니고 스트림을 통해 키보드 입력은 버퍼로 저장
		//nextLine에선 enter까지 읽어서 버퍼에 남지 않음,
		//반면 nextint는 enter를 못읽어서 버퍼에 남음
		//=>전화번호로 넘어갔을 때 버퍼에 남은 enter를 바로 읽게됨
		System.out.println("나이? ");
		age=sc.nextInt();
		sc.nextLine(); // 엔터를 읽어서 버림
		System.out.println("전화번호? ");
		tel=sc.nextLine();
		System.out.println("생년월일? ");
		birth=sc.nextLine();
		System.out.printf("이름: %s, 나이: %d, 전화번호: %s, 생년월일: %s"
				, name, age, tel, birth);
		sc.close();
		
	}

}
