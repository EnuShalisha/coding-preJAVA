package com.ex0215;

import java.util.Iterator;
import java.util.Vector;

public class Ex01 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		
		System.out.println("초기용량:"+v.capacity());
		
		v.add("서울");
		v.add("부산");
		v.add("대구");
		v.add("인천");
		v.add("광주");
		v.add("대전");
		v.add("울산");
		v.add("세종");
		v.add("강원");
		v.add("경기");
		v.add("충남");
		v.add("충북");
		
		System.out.println("용량:"+v.capacity());
		
		v.add(0, "한국");
		
		System.out.println("처음요소:"+v.get(0));
		System.out.println("처음요소:"+v.firstElement());
		
		System.out.println("끝:"+v.get(v.size()-1));
		System.out.println("끝:"+v.lastElement());
		
		for(String s:v)
			System.out.print(s+" ");
		System.out.println();
		
		Iterator<String> it=v.iterator();
		while(it.hasNext()) {
			String s=it.next();
			System.out.print(s+" ");
		}
		System.out.println();
		v.clear();
		System.out.println("개수:"+v.size());
		System.out.println("용량:"+v.capacity());
		
		//용량을 개수로 조정
		v.trimToSize();
		System.out.println("용량:"+v.capacity());
	}

}
