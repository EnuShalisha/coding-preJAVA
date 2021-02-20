package com.ex0216;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex03 {

	public static void main(String[] args) {
		List<User3> list=new ArrayList<>();
		list.add(new User3("홍길동", 20));
		list.add(new User3("나나나", 23));
		list.add(new User3("다다다", 21));
		list.add(new User3("구구구", 30));
		list.add(new User3("가기고", 19));
		
		//이렇게 인터페이스 불러와서 클래스 만드는 방법도
		Comparator<User3> comp=new Comparator<User3>() {

			@Override
			public int compare(User3 o1, User3 o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(list, comp);
		
		System.out.println("이름순");
		for(User3 u:list) {
			System.out.println(u.getName()+"-"+u.getAge());
		}
		Comparator<User3> comp2=new Comparator<User3>() {

			@Override
			public int compare(User3 o1, User3 o2) {
				return o1.getAge()-o2.getAge();
			}
		};
		Collections.sort(list, comp2);
		
		System.out.println("나이순");
		for(User3 u:list) {
			System.out.println(u.getName()+"-"+u.getAge());
		}

	}

}


class User3 {
	private String name;
	private int age;
	
	public User3() {
		
	}
	public User3(String name, int age) {
		this.name=name;
		this.age=age;
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
	
	
}