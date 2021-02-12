package com.ex0210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex03 {

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
		
		List<String> list2=new ArrayList<>();
		list2.add("경기");
		list2.add("강원");
		list2.add("충청");
		list2.add("전라");
		list2.add("경상");
		list2.add("제주");
		
		//list2에 list의 모든 데이터 추가
		list2.addAll(list);
		System.out.println(list2);
		
		//list->String[]로 변환
		String[] ss=list.toArray(new String[list.size()]);
		for(String s:ss) {
			System.out.print(s+" ");
		}
		System.out.println();
		
		//String[] -> list
		List<String> list3=Arrays.asList(ss);
		System.out.println(list3);
		
		//sublist(배열 중 일부 추출)
		System.out.println(list2.indexOf("경상"));
		System.out.println(list2.indexOf("서울"));
		List<String> list4=list2.subList(4, 7);
		System.out.println(list4);
		
		//배열 중 일부 삭제
		list2.subList(4, 7).clear();
		System.out.println(list2);
		list2.clear(); //전체삭제
		
	}

}
