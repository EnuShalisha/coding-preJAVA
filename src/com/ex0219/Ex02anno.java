package com.ex0219;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Ex02anno {

	public static void main(String[] args) {
		Test2 tt=new Test2();
		tt.sub();

	}

}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test{
	
}

class Test2{
	@Test
	
	
}