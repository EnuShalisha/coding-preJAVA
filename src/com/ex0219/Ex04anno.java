package com.ex0219;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Ex04anno {

	public static void main(String[] args) {
		try {
			Mycontainer mc=new Mycontainer();
			
			//User04 vo=new User04();
			User04 vo=mc.get(User04.class);
			System.out.println(vo.getName1()+","+vo.getName2()+","+vo.getName3());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Subject{
	String value() default "자바";
}

//애노테이션 값 주입 클래스
class Mycontainer {
	private <T> T invokeAnno(T t) throws IllegalAccessException {
		Field[] ff=t.getClass().getDeclaredFields();
		
		for(Field f:ff) {
			Subject sj=f.getAnnotation(Subject.class);
			if(sj!=null&&f.getType() == String.class) {
				f.setAccessible(true); // private 필드나 메소드
				f.set(t, sj.value()); // 필드에 애노테이션 값 설정
			}
		}
		return t;
	}
	
	<T> T get(Class<?> cls) throws IllegalAccessException, InstantiationException {
		T t=(T)cls.newInstance();
		t=invokeAnno(t);
		return t;
	}
}

//애노테이션 적용
class User04 {
	@Subject
	private String name1;
	
	@Subject("스프링")
	private String name2;
	
	@Subject
	private Integer name3;

	public String getName1() {
		return name1;
	}

	public String getName2() {
		return name2;
	}

	public Integer getName3() {
		return name3;
	}
}