package com.ex0225;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex07 {

	public static void main(String[] args) {
		// 스트림 생성 방법
		
		//컬렉션
		List<String> list=Arrays.asList("a", "b", "c");
		Stream<String> st1= list.stream();
		st1.forEach(System.out::print);
		System.out.println();
		
		//배열-1
		String[] ss=new String[] {"A", "B", "C"};
		Stream<String> st2 = Stream.of(ss);
		st2.forEach(System.out::print);
		System.out.println();
		
		//배열-2
		Stream<String> st3 = Arrays.stream(ss);
		st3.forEach(System.out::print);
		System.out.println();
		
		//IntStream : 제너릭이 필요 x
		IntStream st4=IntStream.range(1, 6); // 1~5
		st4.forEach(System.out::print);
		System.out.println();
		
		IntStream st5=new Random().ints(); // 무한 스트림
		st5.limit(5).forEach(System.out::print);
		System.out.println();
		
		IntStream st6=new Random().ints(5, 1, 10); // 1~9 중 5개만
		st6.forEach(System.out::print);
		System.out.println();
		
		Stream<String> s1= Stream.of(new String[] {"a", "b", "c"});
		Stream<String> s2= Stream.of(new String[] {"x", "y", "z"});
		//두 스크림 결합
		Stream<String> s3 = Stream.concat(s1, s2);
		s3.forEach(System.out::print);
		System.out.println();
		
		
	}

}
