package hw_0121;

import java.util.Scanner;

public class AD07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		//0 이상 정수 판단
		do	{System.out.println("수? ");
			a=sc.nextInt();}
		while(a<0);
		//총 자리 수 계산, 맨 앞 자리 배수 저장
		int count=1; int b=0, c=1;
		while(a-c>=0){
			c=c*10;
			b++;
		}
		c/=10;
		//자리바꾸기 - 각 자릿수대로 배수 나눠서 인수 획득, 나머진 값 초기화 및 저장 과정
		int temp=0, result=0;
		while(b>0) {
			temp=a;
			a/=c;
			result+=count*a;
			a=temp-a*c;
			c/=10;
			count*=10;
			b--;
		}
		
		System.out.println(result);
		sc.close();
		
	}

}
