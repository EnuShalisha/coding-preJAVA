package com.ex0219;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Ex03rfl {

	public static void main(String[] args) {
		String className="com.ex0219.Book";
		
		try {
			Class<?> cls = Class.forName(className);
			
			//기본생성자로 객체 생성
			Constructor<?> con1=cls.getConstructor();
			Book book1 = (Book) con1.newInstance();
			book1.bname();
			
			//파라미터 있는 생성자로
			Constructor<?> con2=cls.getConstructor(String.class);
			Book book2 = (Book) con2.newInstance("스프링");
			book2.bname();
			
			//static 필드 접근
			Field f1= Book.class.getDeclaredField("cname");
			String s1=(String) f1.get(null);
			System.out.println(s1);
			
			//변경하기
			f1.set(null,  "사랑");
			System.out.println(f1.get(null));
			
			//필드 접근
			Field f2=Book.class.getDeclaredField("subject");
			f2.setAccessible(true);
			String s2=(String)f2.get(book2);
			System.out.println(s2);
			
			f2.set(book2, "오라클");
			System.out.println(f2.get(book2));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

class Book{
	public static String cname="대한";
	private String subject="자바";
	
	public Book() {
		
	}
	
	public Book(String subject) {
		this.subject=subject;
	}
	
	public void bname() {
		System.out.println("책 이름: "+subject);
	}
	
	public int sum(int su, int price) {
		return su*price;
	}

}