package com.ex0225;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex08 {

	public static void main(String[] args) {
		IntStream s1 = IntStream.range(0, 10);
		IntStream s2 = new Random().ints(10, 0, 10);
		IntStream s3 = new Random().ints(10, 0, 10);

		s1.skip(4).forEach(System.out::print);
		System.out.println();
		
		s2.distinct().forEach(System.out::print);//중복제거
		System.out.println();
		
		s3.filter(n->n%2!=0).forEach(System.out::print);//중복제거
		System.out.println();
		
		Stream<Integer> s4= Stream.of(7, 8, 4, 6, 7, 2);
		Stream<Integer> s5= Stream.of(7, 8, 4, 6, 7, 2);
		
		s4.sorted().forEach(n->System.out.print(n+" "));
		System.out.println();
		
		//내림차순
		s5.sorted(Comparator.reverseOrder()).forEach(n->System.out.print(n+" "));
		System.out.println();
		
		IntStream s6 = new Random().ints(10, 0, 10);
		IntStream s7 = new Random().ints(10, 0, 10);
		IntStream s8 = new Random().ints(10, 0, 10);
		
		System.out.println(s6.count());
		System.out.println(s7.max().getAsInt());
		//System.out.println(s8.average().getAsDouble());
		
		//하나라도 7 초과 존재하면 true
		System.out.println(s8.anyMatch(n-> n>7));
		
		//모두 7초과면 true
		//System.out.println(s8.allMatch(n-> n>7));
		
	}

}
