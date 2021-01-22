package com.ex0122;

public class Ex07 {

	public static void main(String[] args) {
		/*for(int i=1; i<=5; i++)
		{for(int j=1; j<=i; j++)
			{System.out.print("*");}
		System.out.println();
		}*/
		/*for(int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++)
				System.out.print(" ");
			for(int j=1; j<=i; j++)
				System.out.print("*");
			System.out.println();}*/
		/*for(int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++)
				System.out.print(" ");
			for(int j=1; j<=i*2-1; j++)
				System.out.print("*");
			System.out.println();}
		for(int i=5; i>=1; i--) {
			for(int j=1; j<=5-i; j++)
				System.out.print(" ");
			for(int j=1; j<=i*2-1; j++)
				System.out.print("*");
			System.out.println();*/
		int s=9, n;
		n=s/2;
		for(int i=0; i<s; i++) {
			for (int j=0; j<(s-n); j++) 
				System.out.print((j>=n)?"*":" ");
			System.out.println();
			n=i<(s/2)? n-1:n+1;
		}

}
}
