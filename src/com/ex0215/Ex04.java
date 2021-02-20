package com.ex0215;

import java.util.LinkedHashSet;
import java.util.Set;

public class Ex04 {

	public static void main(String[] args) {
		Set<String> set=new LinkedHashSet<>();
		//링크드: 셋중 입력순서 유지
		set.add("자바");
		set.add("오라클");
		set.add("서블릿");
		set.add("스프링");
		set.add("빅데이터");
		set.add("자바");
		System.out.println(set);
	}

}
