package com.ex0225;

import java.util.function.Consumer;
import java.util.function.IntSupplier;

public class Ex03 {

	public static void main(String[] args) {
		Consumer<Long> c = (t) -> System.out.println(t);
		c.accept(100L);
		//매개변수는 있으나 리턴이 없음
		
		IntSupplier i = () -> (int) (Math.random()*10)+1;
		System.out.println(i.getAsInt());
		//매개변수는 없으나 리턴이 있음
	}

}
