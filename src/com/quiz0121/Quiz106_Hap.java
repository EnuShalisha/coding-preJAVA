package com.quiz0121;
import java.util.Scanner;

public class Quiz106_Hap {
	public static void main(String[] args) {
/*		
		두 정수를 입력 받아 입력 받은 수중 적은 수에서 큰 수까지의 합
*/
		Scanner sc = new Scanner(System.in);

		int num1, num2, temp;
		int n, s;
		
		System.out.print("두수 ? ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();

		if(num1 > num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}

		s = 0;
		n = num1;
		while(n <= num2) {
			s+=n;
			n++;
		}
		System.out.printf("%d ~ %d 까지의 합 = %d\n" , num1, num2, s);
		
		sc.close();
	}
}
