package com.ex0205;

public class Ex06 {

	public static void main(String[] args) {
		Apple a = new Apple();
		Orange o = new Orange();
		
		Store st = new Store();
		st.packing(o);
		st.packing(a);

	}

}

interface Fruit {
	public int getPrice();
	public String getName();
}

class Apple implements Fruit {

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String getName() {
		return "Apple";
	}
	
}

class Orange implements Fruit{

	@Override // 아래 packing 메소드의 의존관계를 인터페이스로써 클래스에 전이
	//즉 클래스가 바뀌면 클래스에서 책임을 져야하는 형태
	public int getPrice() {
		return 500;
	}

	@Override
	public String getName() {
		return "Orange";
	}
	
}

class Store {
	/*public void packing(Apple a) { // apple한테 의존관계 -> 강한 의존관계(fruit 없이 배타적 활동 불가)
	fruit 내용이 바뀌면 이 메소드 자체가 컴파일 오류
		System.out.println(a.getName()+":"+a.getPrice());
	}
	
	public void packing(Orange o) {
		System.out.println(o.getName()+":"+o.getPrice());
	}*/
	
	public void packing(Fruit f) { //fruit한테 의존관계 -> interface와의 비교적 약한 의존관계
		//이 메소드 입장에선 클래스를 직접 참조하는게 아닌 interface에 달림
		//즉 인터 임플한 클래스가 달라지더라도 위 메소드를 수정할 필요 x
		//interface만 노출돼있어서 클래스와의 의존관계가 사라짐
		System.out.println(f.getName()+":"+f.getPrice());
	}
	//이거시 상속의 힘 - 자동 업캐스팅
}