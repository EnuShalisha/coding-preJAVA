package hw_0121;

import java.util.Scanner;

public class AD08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=0;
		do	{System.out.println("정수 ? ");
			a=sc.nextInt();}
			while(a<2);
		System.out.print(a+" = ");
		int b=1;
		while(a!=1) {
			b++;
			if (a%b==0)
				{System.out.print(b);
				a=a/b;
				if(a!=1) 
					System.out.print("*");
				b=1;
				}
			}
		sc.close();
		}
}

