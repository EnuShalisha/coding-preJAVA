package com.ex0210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//linkedlist가 arraylist보다 훨씬 빠르다
public class Ex04 {

	public static void main(String[] args) {
		List<String> list1=new ArrayList<String>();
		List<String> list2=new LinkedList<String>();
		
		long s, e;
		
		s=System.nanoTime();
		for(int i=1; i<=100000; i++) {
			list1.add("테스트-"+i);
		}
		e=System.nanoTime();
		System.out.println("ArrayList:"+(e-s));
		
		s=System.nanoTime();
		for(int i=1; i<=100000; i++) {
			list2.add("테스트-"+i);
		}
		e=System.nanoTime();
		System.out.println("LinkedList:"+(e-s));
		
/*
 * - 대량의 데이터를 등록하는 경우 LinkedList가 더 빠름
 * - 빈번한 추가 삭제가 일어나는 경우 Linkedlist도 더 효율적
 * - 검색은 ArrayList가 더 빠름
 * - LinkedList도 동기화되지 않아 멀티쓰레드에서 안전하지 못함ㅇㄷ
 */

	}

}
