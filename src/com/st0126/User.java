package com.st0126;

public class User implements Promise{ // 여러개 상속 가능
	String userName;
	int level;
	
	public User() { // 위 클래스명과 동일, user 선언하면 자동 생성
		this("깜따긔야"); // this로 선언 가능 / constructor는 제일 위로
		System.out.println("자동생성");
		
	}
	
	public User(String userName) { // 매개변수를 통해 구분
		this.userName=userName;
		System.out.println(userName);
	}
	
	public User(String userName, int level) {
		this.userName=userName;
		this.level=level;
		System.out.println(userName+" "+level);
	}
	
	void setUserName(String userName) {
		this.userName = userName; // 메소드 바깥의 문자열 채용
	}
	
	String getUserName() {
		return userName;
	}
	
	//constructor 생성자
	
	public void info() {
		System.out.println("Personal Info");
	}
}
