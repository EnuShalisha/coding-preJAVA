package com.ex0219;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex01class {

	public static void main(String[] args) {
		try {
			//Class<?> cls=String.class;
			Class<?> cls=Class.forName("java.lang.String");
			
			System.out.println(cls.getSuperclass());
			
			System.out.println("\n생성자");
			Constructor<?>[] cc=cls.getConstructors();
			for(Constructor<?> c:cc)
				System.out.println(c);
			
			System.out.println("\n필드");
			Field[] ff=cls.getDeclaredFields();//private도
			//cls.getFields();는 public만
			for(Field f:ff)
				System.out.println(f);
			
			System.out.println("\n메소드");
			Method[] mm=cls.getDeclaredMethods();
			for(Method m:mm)
				System.out.println(m);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
