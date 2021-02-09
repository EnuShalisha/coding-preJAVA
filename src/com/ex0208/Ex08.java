package com.ex0208;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex08 {

	//이것이 checked exception을 만드는 방법
	public static void main(String[] args) {
		Sample08 ss=new Sample08();
		
		try {
			System.out.println("국어? ");
			int s1=ss.inputNumber();
			//여기에 if(s<0)을 일일이 다 넣어야될까? 교과목이 100개가 있다면 전부다?
			System.out.println("영어? ");
			int s2=ss.inputNumber();
			System.out.println("수학? ");
			int s3=ss.inputNumber();
			System.out.println("결과: "+s1+","+s2+","+s3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			
		}
		
	}

}

class Sample08 {
	private Scanner sc = new Scanner(System.in);
	
	public int inputNumber() throws Exception{
		//throws: 던진 오류를 메인에서 명시해야함
		int result=0;
		
		try {
			result = sc.nextInt(); //지금까지 해온건 예외를 잡는거
			//지금부턴 예외를 발생하는 것
			if(result<0) {
				throw new Exception("0 이상만 가능");
				//throw new: 예외를 만듬
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // 엔터 버림
			throw new Exception("숫자만 가능합니다.");
		}
		return result;
	}
}