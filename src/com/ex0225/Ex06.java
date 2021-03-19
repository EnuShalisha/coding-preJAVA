package com.ex0225;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex06 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "x", "a", "t", "c", "x", "y", "a");
		
		Stream<String> st=list.stream();
		st.distinct().limit(3).sorted().forEach(System.out::println); 
		// distinct: 중복 제거 중간연산
		// limit: 3개만 받도록
		// sorted: 정렬해서
		// forEach(Systemout::println): 요게 최종연산
		
		//중간연산은 최종연산 전 수행 x(지연 연산)
		//최종연산은 스트림의 요소를 모두 소모
		

	}

}
