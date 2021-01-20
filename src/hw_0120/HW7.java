package hw_0120;

import java.util.Scanner;

public class HW7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름? ");
		String n=sc.next();
		System.out.println("세과목 점수? ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		double d=(double) ((a+b+c)/3);
		String e="불합격";
		if(d>=60)
		{if(a>=40&&b>=40&&c>=40) {
			e="합격";
			}
		else {
			e="과락";
			}
		}
		System.out.printf("%s님은 %s 입니다.", n, e);
	}

}
