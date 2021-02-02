package com.ex0201;

public class Ex04api {

	public static void main(String[] args) {
		int a=10, b;
		
		Integer ob;
		Long ob2;
		String s;
		double d;
		
		ob=a; // �����Ϸ����� �ڵ����� �ҽ� �ٲ���. autoboxing. 
		ob=new Integer(a); // int -> Integer; ���� ����
		// ob2=a; wrapperŬ�����ʹ� �ڷ����� ���ƾ���
		
		b=ob; // Integer->int �ڵ� ��ȯ. auto-unboxing.
		b=ob.intValue();
		
		s="123";
		a=Integer.parseInt(s);
		System.out.println(a);
		
		s="123.7"; 
		//a=Integer.parseInt(s); ��Ÿ�ӿ���
		//System.out.println(a);
		
		d=Double.parseDouble(s);
		System.out.println(d);
		
		b=10;
		s=""+b; 
		s=Integer.toString(b);
		System.out.println(s);
		
		ob2=10L;
		s=Long.toString(ob2);
		System.out.println(s);
		
		a=30;
		s=Integer.toString(a, 16);
		System.out.println(s);
		
		
		
	}

}
