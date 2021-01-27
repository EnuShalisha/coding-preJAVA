package com.st0126;

public class Ex01 {
//메인메소드가 존재하면 이후엔 메인 생략
	public static void main(String[] args) {
		Person person1 = new Person();
		person1.name = 	"rin";
		person1.bloodtype = "o";
		person1.speak("SH", "G"); // speak 메소드 내 매개변수와 위에 정의된 name, blodtype은 별개
		
		Person person2 = new Person();
		person2.name = "Jera";
		person2.bloodtype="b"; 
		
		System.out.println(person1.name);

	}

}
