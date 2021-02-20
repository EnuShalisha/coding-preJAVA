package com.ex0216;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex02 {

	public static void main(String[] args) {
		//Treeset: comparable 인터페이스가 구현되어 있어야 사용 가능
		//즉 Set<Usdr2> list=new TreeSet<>();도 이젠 구현 가능
		List<User2> list=new ArrayList<>();
		list.add(new User2("홍길동", 20));
		list.add(new User2("나나나", 23));
		list.add(new User2("다다다", 21));
		list.add(new User2("구구구", 30));
		list.add(new User2("가기고", 19));
		
		Collections.sort(list);
		for(User2 u:list) {
			System.out.println(u.getName()+" - "+u.getAge());
		}
		
		
	}

}
// Comparable 인터페이스: 정렬 기준 설정
class User2 implements Comparable<User2>{
	private String name;
	private int age;
	
	public User2() {
		
	}
	public User2(String name, int age) {
		this.name=name; this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(User2 o) {
		return age - o.getAge();
		//return -(age - o.getAge()); : 내림차
		//return name.compareTo(o.getName()); : 이름 오름차
	}
	
}