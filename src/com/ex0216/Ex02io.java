package com.ex0216;

import java.io.IOException;

public class Ex02io {

	public static void main(String[] args) {
		int n, data;
		
		n=0;
		try {
			System.out.print("수?");
			while((data=System.in.read())!=13) {
				data=data-48;
				n=n*10+data;
			}
			int s=0;
			for(int i=1; i<=n; i++)
				s+=i;
			System.out.println("결과:"+s);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
