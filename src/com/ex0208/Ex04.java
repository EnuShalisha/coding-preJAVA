package com.ex0208;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b, c;
		
		try {
			System.out.print("첫번째 수: ");
			a=sc.nextInt();
			System.out.print("두번째 수: ");
			b=sc.nextInt();
			c=a/b;;
			System.out.println("결과 수: ");
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력 가능");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("반드시 실행");
			sc.close();
		}
		
		System.out.println("종료");

	}

}
