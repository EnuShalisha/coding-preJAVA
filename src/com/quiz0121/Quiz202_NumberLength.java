package com.quiz0121;
import java.util.Scanner;

public class Quiz202_NumberLength {
	public static void main(String[] args) {
/*		
		정수를 입력 받아 입력 받은 수의 길이 구하기
*/		
		Scanner sc = new Scanner(System.in);

		int num, len, temp;

		System.out.print("수 ? ");
		num = sc.nextInt();

		len = 1;
        temp=num;
		if(num<0)
			temp=-num;

		while(temp>=10) {
				temp=temp/10;
				len++;
		}

		System.out.println(num+"은 "+len+"자리 정수");
		
		sc.close();
	}
}
