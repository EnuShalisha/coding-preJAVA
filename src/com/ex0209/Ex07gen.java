package com.ex0209;

public class Ex07gen {

	public static void main(String[] args) {
		Demo7<Integer> ob1=new Demo7<>();
		ob1.set(10);
		
		Number nn=new Integer(10); // upcasting, 정상
		//Demo7<Number> ob2=ob1; 컴파일 오류. 상속관계와 다름. 엄격함.
		
		Demo7<?> ob2=ob1; //? cf.object
		//ob2.set(100); 그러나 이렇다고 Integer로 임의로 결정되는 것도 아님
		ob2.print(); // 이경우엔 의존관계가 아니라 가능
	}

}

class Demo7<T>{
	private T t;
	public void set(T t) {
		this.t=t;
	}
	public T get() {
		return t;
	}
	
	public void print() {
		System.out.println(t.getClass().getName()+","+t);
	}
}