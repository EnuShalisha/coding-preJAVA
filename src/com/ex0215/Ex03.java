package com.ex0215;

import java.util.HashSet;
import java.util.Set;

public class Ex03 {

	public static void main(String[] args) {
		//중복허용 x, 순서 x
		Set<String> set=new HashSet<String>();

		set.add("자바");
		set.add("오라클");
		set.add("서블릿");
		set.add("스프링");
		set.add("HTML");
		System.out.println(set);
		set.add("자바");//중복데이터 추가 x
		System.out.println(set);
		
		for(String s:set) {
			System.out.print(s+" ");
		}
		System.out.println();
	}

}
