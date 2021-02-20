package com.ex0219;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import com.sun.tools.javac.code.Attribute.RetentionPolicy;

public class Ex03anno {

	public static void main(String[] args) {
		Test3 tt=new Test3();
		//tt.sub1();
		//tt.sub2();
		
		Method[] mm=Test3.class.getDeclaredMethods();
		
		for(Method m:mm) {
			//System.out.println(m.getName()
			
		//print 에노테이션 적용?
			if(m.isAnnotationPresent(Print.class)) {
				System.out.println("["+m.getName()+"]");
			}
			Print pt=m.getAnnotation(Print.class);
			
			for(int i=0; i<pt.number(); i++) {
				System.out.print(pt.value());
			}
			System.out.println();
			
			try {
				m.invoke(new Test3()); //메소드 호출
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}

@Target({ElementType.METHOD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@interface Print{
	String value() default "-";
	int number() default 15;
}

class Test3{
	@Print
	public void sub1() {
		System.out.println("테스트-1");
	}
	
	@Print("*")
	public void sub2() {
		System.out.println("테스트-2");
	}
	
	@Print(value="#", number=20)
	public void sub3() {
		System.out.println("테스트-3");
	}
}