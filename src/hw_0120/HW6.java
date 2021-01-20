package hw_0120;

import java.util.Scanner;

public class HW6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두수 ? ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println("연산자[+, -, *, /] ?");
		char c=sc.next().charAt(0);
		int d=0;
		if(c>=0) {
			if(c=='+') {
				d=a+b;
			}
			else if(c=='-') {
			d=a-b;
		}
			else if(c=='*') {
			d=a*b;
		}
			else if(c=='/') {
			d=a/b;
		}
			else {
			System.out.println("연산자 오류");
			}
		}
		System.out.printf("%d %c %d = %d", a, c, b, d);
		sc.close();
	}
}
