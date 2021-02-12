package com.ex0210;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ex02 {

	public static void main(String[] args) {
	List<String> list=new ArrayList<>();
		
		list.add("서울");
		list.add("부산");
		list.add("대구");
		list.add("인천");
		list.add("광주");
		list.add("대전");
		list.add("울산");
		list.add("세종");
		
		Iterator<String> it=list.iterator();
		while(it.hasNext()) {
			String s=it.next();
			System.out.print(s+" ");
		}
		System.out.println();
		
		//만약 역순으로 갖고오고싶으면?
		System.out.println("역순-1");
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		
		System.out.println("전체-2");
		ListIterator<String> it2 = list.listIterator(); // 이상태는 반복자 가장 처음
		//a b c d e
		//반복자 위치
		//1->
		//       1
		//반복자가 여기 위치하니 앞에걸 가져오자
		while(it2.hasNext()) {
			String s=it2.next();
			System.out.print(s+" ");
		} // 마치고나면 반복자는 가장 마지막
		System.out.println();
		
		//역순은 ListIterator만 가능
		//역순은 반복자의 위치가 가장 마지막에 있어야 가능
		System.out.println("역순-2");
		while(it2.hasPrevious()) {
			String s=it2.previous();
			System.out.print(s+" ");
		}
		System.out.println();
		
		System.out.println("처음부터 역순");
		ListIterator<String> it3=list.listIterator(list.size()); // 반복자를 가장 뒤로 초기화
		while(it3.hasPrevious()) {
			String s=it3.previous();
			System.out.print(s+" ");
		}
		System.out.println();
	}

}
