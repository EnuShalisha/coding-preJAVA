package com.ex0203;

import java.util.Scanner;

public class Exam01UI {


	public static void main(String[] args) {
		Exam01 ex = new Exam01();
		Exam01VO vo = new Exam01VO();
		Exam01VO vo2 = new Exam01VO();
		Scanner sc = new Scanner(System.in);
		int out=0;
		int count=0;
		
		vo=ex.toNumber3();
		
		a:
		while(true) {
		System.out.println("서로 다른 3개의 숫자로 수 입력[123~987]: ");
		String user=sc.next();
		vo2=ex.input(user);
		if(vo2==null) {
			System.out.println("재입력하세요.");
			continue a;
			}
		vo=vo2;
		vo.setUser(user);
		ex.compare(vo);
		if(vo.getStrike()==3)
			out++;
		System.out.printf("%d strikes, %d balls, %d hits, %d outs\n", 
				vo.getStrike(), vo.getBall(), vo.getHit(), out);
		count++;
		if(out==3)
			{System.out.println("망했습니다..");
			break;}
		if(vo.getHit()==3)
			{System.out.println(count+"번만에 성공!");
			break;}
			}
		}
		
		
		
		
	}

