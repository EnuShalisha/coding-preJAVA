package com.ex0216;

import java.util.PriorityQueue;

public class Ex05 {

	public static void main(String[] args) {
		// comparable 인터페이스 구현시에만 가능
		//우선순위 큐
		
		PriorityQueue<User5> pq=new PriorityQueue<User5>();
		
		pq.offer(new User5("다다다", 25));
		pq.offer(new User5("고고고", 22));
		pq.offer(new User5("가가가", 23));
		pq.offer(new User5("머머머", 27));
		pq.offer(new User5("머가가", 22));
		
		while(pq.peek()!=null) {
			User5 u=pq.poll();
			System.out.println(u.getName()+"-"+u.getAge());
		}

	}

}

class User5 implements Comparable<User5>{
	private String name;
	private int age;
	
	public User5() {
		
	}
	
	public User5(String name, int age) {
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
	public int compareTo(User5 o) {
		return name.compareTo(o.getName());
	}
}