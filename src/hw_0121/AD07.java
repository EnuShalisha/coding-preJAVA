package hw_0121;

import java.util.Scanner;

public class AD07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		do	{System.out.println("수? ");
			a=sc.nextInt();}
		while(a<0);
		int count=1; int b, c;
		b=0; c=1;
		while(a-c>=0){
			c=c*10;
			b++;
		}
		c/=10;
		int temp=0, result=0;
		while(b>0) {
			temp=a;
			a/=c;
			System.out.println(a);
			result+=count*a;
			a=temp-a*c;
			System.out.println(result);
			c/=10;
			//System.out.println(c);
			count*=10;
			b--;
		}
		System.out.println(result);
		
	}

}
