package hw_0121;

import java.util.Scanner;

public class AD09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 ? ");
		int a=sc.nextInt();
		int b=1;
		while(true) {
			b++;
			if(a%b==0 || a<=1) 
				break;
			}
		if (a!=b)
			System.out.printf("%d : 소수가 아님", a);
		else
			System.out.printf("%d : 소수임", a);

	}

}
