package com.ex0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {

	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(
				new InputStreamReader(System.in));
		//br.readLine() - 문자열 입력받음
		
		int a, b, c;
		
		
/*		try {
			//예외 발생 가능성 코드 
			System.out.print("첫번쨰 수? ");
			a=Integer.parseInt(br.readLine());
			
			System.out.println("두번째 수?");
			b=Integer.parseInt(br.readLine());
			c=a+b;
			System.out.println("결과:"+c);
		} catch (IOException e) {
			//예외 발생 시 실행할 코드
			e.printStackTrace();
		} //컴파일오류-예외처리해야함
		//키보드 입력 말고 다른 입력도 받음, 단 입력받는다는 보장이 없음
		//checked exception - 반드시 예외처리를 해야 사용할 수 있는 메소드가 있음
		
		//결국 예외를 짤땐 클라이언트 입장에서, 문제가 뭐고 어떻게 해결해야하는지 명시해야함
*/		try {
			System.out.print("첫번쨰 수? ");
			a=Integer.parseInt(br.readLine());
	
			System.out.println("두번째 수?");
			b=Integer.parseInt(br.readLine());
			c=a+b;
			System.out.println("결과:"+c);
			} catch (Exception e) { // exception: 모든 예외의 상위 클래스
				//System.out.println(e.toString()); // 예외가 나오는데 프로그램은 죽지않고 정상적으로 종료
				//System.out.println(e.getMessage()); 
				e.printStackTrace();
				//상세한 정도: trace>tostring>message
			}
		System.out.println("프로그램 종료");

	}

}
