package com.ex0215;

import java.util.Set;
import java.util.TreeSet;

public class Ex06 {

	public static void main(String[] args) {
		Set<Integer>set=new TreeSet<>();
		/*for(int i=0; i<6; i++)
			{int a=(int)(Math.random()*45)+1;
			if(!set.add(a))
				i--;
			}
		*/
		while(set.size()<6) {
			int n=(int)(Math.random()*45)+1;
			set.add(n);
		}
		System.out.println(set);

	}

}
