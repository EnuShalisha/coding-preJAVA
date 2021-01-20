package com.ex0120;

public class Ex10 {

	public static void main(String[] args) {
		int x, y, z;
		boolean b;
		x=y=z=-1;
		b=((++x!=0)&(++y!=0)&(++z!=0));
		System.out.printf("%d, %d, %d, %b\n", x, y, z, b);
		x=y=z=-1;
		b=((++x!=0)&&(++y!=0)&&(++z!=0));
		System.out.printf("%d, %d, %d, %b", x, y, z, b);

	}

}
