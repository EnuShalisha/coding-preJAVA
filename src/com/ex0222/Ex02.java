package com.ex0222;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex02 {

	public static void main(String[] args) {
		try {
			String className="com.ex0222.Test2";
			
			Class<?> cls = Class.forName(className);
			
			//JDK8부터는 권장하지 않음
			Object obj = cls.newInstance(); // 이거 하나만 쓰면 상관 x
			Field[] ff=cls.getDeclaredFields();
			
			//세터 만들기
			for(Field f:ff) {
				String name=f.getName();
				String first=name.substring(0, 1).toUpperCase();
				String last=name.substring(1);
				String setter="set"+first+last;
				
				Method m=cls.getDeclaredMethod(setter, f.getType());
				
				if(f.getName().equals("name")) {
					m.invoke(obj, "김자바");
				} else if(f.getName().equals("tel")) {
					m.invoke(obj, "010");
				} else if(f.getName().equals("age")) {
					m.invoke(obj, 20);
				}
			}	
				System.out.println("-----------------");
				for(Field f:ff) {
					String name=f.getName();
					String first=name.substring(0, 1).toUpperCase();
					String last=name.substring(1);
					String getter="get"+first+last;
					
					Method m=cls.getDeclaredMethod(getter);
					Object rt=m.invoke(obj);
					
					if(f.getType().getName().equals("java.lang.String")) {
						String s=(String)rt;
						System.out.println(f.getName()+":"+s);
					}else if(f.getType().getName().equals("int")) {
						int i=(int)rt;
						System.out.println(f.getName()+":"+i);
					}
				}
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

class Test2{
	private String name;
	private String tel;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}