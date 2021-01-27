package com.st0126;

class Person {
	
		String name; // 인스턴스 베어리어블
		String bloodtype;
		int age=20;
		
		void speak(String name, String bloodtype) { // ()안에 들어가는 파라미터
			System.out.println("저의 이름은"+name+"이고 혈액형은"+bloodtype+"입니다.");
		}
		String getName() { // 보이드가 없으면 리턴이 필요함
			return name;
		}
		
		int getAge() {
			return age;
		}
	} // 패키지 안에서 한번 선언되면 다른 클래스에서 선언 x
