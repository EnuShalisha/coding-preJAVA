package com.ex0210;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex01 {

	public static void main(String[] args) {
		//arraylist: list 인터페이스를 구현한 클래스
		List<String> list=new ArrayList<>();
		
		list.add("서울");
		list.add("부산");
		list.add("대구");
		list.add("인천");
		list.add("광주");
		list.add("대전");
		list.add("울산");
		list.add("세종");
		System.out.println(list);
		
		//데이터개수
		System.out.println("전채개수:"+list.size());
		System.out.println("처음:"+list.get(0));
		System.out.println("마지막:"+list.get(list.size()-1));
		
		//처음위치에 한국 추가
		list.add(0, "한국");
		System.out.println(list.get(0));
		System.out.println("전체개수:"+list.size());
		
		//처음위치 값 변경
		list.set(0, "대한민국");
		System.out.println(list);
		
		//몇번째 인덱스에?
		System.out.println(list.indexOf("서울"));
		//없으면 -1
		
		//존재여부- boolean
		System.out.println(list.contains("서울"));
		
		//처음값 삭제
		list.remove(0); // 또는 list.remove("대한민국");
		System.out.println(list);
		
		//전체출력 1 - for문
		//전체출력 2 - 확장된 for문
		
		//전체출력 3 - 반복자
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s=it.next();
			System.out.print(s+" ");
		}
		System.out.println();
		
		list.clear();
		System.out.println("모두삭제:"+list);
	}

}
