package com.ex0120;

public class Ex04 {

	public static void main(String[] args) {
		int a;
		boolean b1, b2;
		
		a=10;
		b1=false;
		b2= (a>=20) && (b1=true);
		System.out.println(b1+"&"+b2); // a>=20 이후로 볼필요도 없다 -> b1 진리값 안바뀜
		
		a=10;
		b1=false;
		b2= (a<20) && (b1=true);
		System.out.println(b1+"&"+b2);
		/*	1. a<20 : true
			2. b1=true
			3. b1=true : true
			4. &&
			5. b2=true
		 */	
		a=10;
		b1=false;
		b2= (a>=20) || (b1=true);
		System.out.println(b1+"&"+b2);
		
		a=10;
		b1=false;
		b2= (a<20) || (b1=true); // a<20 이후로 볼필요도 없다 -> b1 진리값 안바뀜
		System.out.println(b1+"&"+b2);
		
		
	}
	

}
