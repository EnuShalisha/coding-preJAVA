package com.ex0122;


public class Ex12 {

	public static void main(String[] args) {
		label:
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				if(i+j==4) {
					break label;
				}
				System.out.println(i+","+j);
		}

	}

}
}
