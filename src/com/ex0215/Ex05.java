package com.ex0215;

import java.util.Set;
import java.util.TreeSet;

public class Ex05 {

	public static void main(String[] args) {
			Set<String> set=new TreeSet<>();
			//링크드: 순서대로 정렬(comparble 구현 클래스만 가능?)
			//ㄱㄴㄷ순으로 정렬
			set.add("자바");
			set.add("오라클");
			set.add("서블릿");
			set.add("스프링");
			set.add("빅데이터");
			System.out.println(set);

	}

}
