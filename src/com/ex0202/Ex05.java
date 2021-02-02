package com.ex0202;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str;
		
		System.out.print("수식? ");
		str=sc.nextLine(); // next 는 공백입력 x, line은 공백입력 o
		str.strip().replaceAll("\\s", "");
		
		if(!str.matches("^\\d+[\\+|\\-|\\*|\\/]\\d+$")) {
			//숫자이상 사이에 +-*/으로 사칙연산을 하는가
			System.out.println("입력 형식 오류");
			sc.close();
			return;
		}
		
		//1) +의 위치 알아내기: indexOf()
		//2) +를 기준으로 왼쪽과 오른쪽 숫자 분리
		//Integer.parseInt(str.substring());
		
		/*int pos= str.indexOf("+");
		int num1=Integer.parseInt(str.substring(0, pos-1));
		int num2=Integer.parseInt(str.substring(pos+1));
		System.out.println(num1+","+num2);*/
		
		for(String op: new String[] {"+","-","*","/"}){
			int pos = str.indexOf(op); // 없으면 -1
			if(pos<1) { //해당 연산자가 없으면
				continue; // -> 연산자 로딩하게됨
			}
			int num1=Integer.parseInt(str.substring(0, pos));
			int num2=Integer.parseInt(str.substring(pos+1));
			
			int result=0;
			switch(op) {
			case "+":result=num1+num2; break;
			case "-":result=num1-num2; break;
			case "*":result=num1*num2; break;
			case "/":result=num1/num2; break;
			}
			System.out.println(num1+op+num2+"="+result);
			break;
		}
		
		sc.close();
	}

}
