package com.ex0122;

public class Ex03 {

	public static void main(String[] args) {
		int s, count;
		s=0;
		count=0;
		for(int  n=1; n<=100; n++){
			if(n%3!=0 && n%5!=0)
				s+=n;
				count++;
		}
		System.out.println(s+" "+s/count);

	}

}
