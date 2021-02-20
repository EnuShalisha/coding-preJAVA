package com.ex0218;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ex03 {

	public static void main(String[] args) {
		String pathname="object2.txt";
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathname))) {
			oos.writeObject(new User("자바", 20, "0100000"));
			oos.writeObject(new User("스프링", 15, "0101111"));
			oos.writeObject(new User("HTML", 25, "0102222"));
			
			System.out.println("저장 완료");
			//왜 저장완료가 안뜨고 터지는가
			//저 위에는 사실상 파일의 주소를 저장하는 개념
			//우린 오브젝트 스트림에 값을 저장해야 함
			//hashtable vs 일반 user 클래스 차이: 직렬화가 되어있는ㄱ ㅏ아닌가
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}

//메소드 직렬 x, 스태틱 변수 x, transient x

class User implements Serializable{  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//직렬화
	
	public User() {}
	
	public User(String name, int age, String tel) {
		this.name=name; this.age=age; this.tel=tel;
	}
	private String name;
	private transient int age; // 직렬화할 필요 없는 예시
	private String tel;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}