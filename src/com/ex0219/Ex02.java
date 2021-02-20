package com.ex0219;

public class Ex02 {

	public static void main(String[] args) {
		System.out.println(City.SEOUL);
		System.out.println(City.SEOUL.getCount());
		
		for(City c:City.values()) {
			System.out.println(c);
		}

	}

}

enum City{
	
	//생성자 안만들면 오류
	SEOUL("서울", 1000), BUSAN("부산", 350), DAEGU("대구", 250);

	private String name;
	private int count;
	
	//생성자는 private만 가능
	private City(String name, int count) {
		this.name=name;
		this.count=count;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return this.name + "->" + this.count;
	}
	
}