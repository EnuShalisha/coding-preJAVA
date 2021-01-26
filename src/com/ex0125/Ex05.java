package com.ex0125;

public class Ex05 {

	public static void main(String[] args) {
		
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				if(i+j==4)
					continue;
				System.out.println("i:"+i+", j:"+j);
			}
		}
		System.out.println("--------");
		gogo:
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				if(i+j==4)
					continue gogo;
				System.out.println("i:"+i+", j:"+j);
			}
		}
		
	}

}
