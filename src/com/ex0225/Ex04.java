package com.ex0225;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Ex04 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B", "C");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s=it.next();
			System.out.print(s+" ");
		}
		System.out.println();
		
		Stream<String> st=list.stream(); // 스트림은 한번 소비하면 다 흘러나감
		//st.forEach(s->System.out.print(s+" "));
		st.forEach(System.out::print);
		System.out.println();

	}

}
