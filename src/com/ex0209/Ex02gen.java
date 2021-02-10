package com.ex0209;

public class Ex02gen {
//제네릭 장점
	//강제 캐스팅 감소
	//컴파일로 오류 체크, 안정성 증가
	//재사용성 증가 유지보수 편리
	public static void main(String[] args) {
		Demo2<Integer> ob1=new Demo2<Integer>(); // 5 6 버전
		ob1.set(10);
		Integer ii = ob1.get()+10; // 다운캐스팅 불필요
		System.out.println(ii);
		
		Demo2<String> ob2=new Demo2<>(); // 7버전
		ob2.set("서울");
		System.out.println(ob2.get());
		
	}

}
//이게 제네릭. 인스턴스 생성시에 자료형 결정.
class Demo2<T>{
	private T a;
	
	public void set(T a) {
		System.out.println(a.getClass().getName());
		this.a=a;
	}
	
	public T get() {
		return a;
	}
	
	
}