package com.ex0121;

public class Ex08wh {

	public static void main(String[] args) {
		int n=0, cnt=0;
		while(n<100)
			{n++;
			if(n%3!=0&&n%5!=0)
			{System.out.print(n+"\t");
			cnt++;
			if(cnt%10==0)
			System.out.println();
		}
	}
		System.out.printf("\n총 개수는 %d개", cnt);
}
		}

