package com.ex0204;

public class Ex01eql {

	public static void main(String[] args) {
		User u1 = new User("홍길동", "010-0000-0000");
		User u2 = new User("홍길동", "010-0000-0000");
		
		System.out.println(u1==u2);
		System.out.println(u1.equals(u2));
		
		
	}

}

class User {
	private String name;
	private String tel;
	
	public User() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		User u =(User)obj; // 이때 필요한게 다운캐스팅 / obj에선 sub의 필드를 못받으므로
		
		return name.equals(u.name)&&tel.equals(u.tel); // string equals로 리턴 변경 
	}
	
	public User(String name, String tel) {
		this.name=name;
		this.tel=tel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}