package com.ex0208;
//올바른 예외처리 방법
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03 {

	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(
				new InputStreamReader(System.in));
		
	int a, b, c;
	
	try {
		System.out.println("첫번째 수? ");
		a=Integer.parseInt(br.readLine());
		System.out.println("두번째 수? ");
		b=Integer.parseInt(br.readLine());
		
		c=a/b;
		
		System.out.println("결과:"+c);
	} catch (IOException e) { // 1. checked exception - IOExcept
		e.printStackTrace();
	} catch (NumberFormatException e) { // 2. unchecked exception - NFExcept: 문자열을 숫자로 변환 불가능
		System.out.println("숫자만 입력 가능");
	} catch (ArithmeticException e) { // 3. unchecked exception - ArithmeticExcept: 산술연산이 안되는경우
		System.out.println("0으로 나눌 수 없음");
	} // 만약 이 이외에도 캐치해야할 사항이 있겠다싶으면
	catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("프로그램 종료");
	}
	
}
