package com.ex0201;

public class Ex03 {

	public static void main(String[] args) {
		Test03 t;
		t=new Test03();
		
		Test03 t2=new Test03();
		Test03 t3=new Test03();
		
		t=null;
	}

}
/*
 * 1) static ���� �޸� �Ҵ�(a, b)
 * 2) static ���� �ʱ�ȭ(a<-10, b<-0)
 * 3) (������) static �ʱ�ȭ ��
 * 
 *	��ü�� �����Ǵ� ���
 *4) instance ���� �޸� �Ҵ�
 *5) instance ���� �ʱ�ȭ(c<-20, d<-0)
 *6) (������) instance �ʱ�ȭ ��
 *7) �������� ��ü�� ����
 *
 *	��ü�� �ٽ� �����Ǵ� ���
 *8) instance ���� �޸� �Ҵ�
 *9) instance ���� �ʱ�ȭ(c<-20, d<-0)
 *10) (������) instance �ʱ�ȭ ��
 *11) �������� ��ü�� ����
 */
class Test03{
	//Ŭ���� ���� ���� - ������ �������� ���� ���ؼ�
	static int a=10;
	static int b;
	
	int c=20;
	int d;
	
//	System.out.println("test"); ����ο��� ���๮�� ������ ����
	
	static { // static �ʱ�ȭ �� - �ʱⰪ�� ��� �ִ°�
		//�����ڿ� �ʱ�ȭ�ָ� �ȵ� - ��� �ʱ�ȭ
		b=15;
		System.out.println("static �ʱ�ȭ");
	}
	
	{ //instance �ʱ�ȭ �� - ������ �����ڷ� ��ü ������ ���
		d=25;
		System.out.println("instance �ʱ�ȭ");
	}
	
	public Test03() {
		System.out.println("������");
	}
	
	public static void print() {
		System.out.println(a+","+b);
	}
	
	public void write() {
		System.out.println(a+","+b+","+c+","+d);
	}
	}

/*
 * ���� �޸� ����: ��������, �Ű�����
 * �޼ҵ� ȣ��� �Ҵ�, ����� ����
 * 
 * �� �޸� ���� :  �ν��Ͻ� ����
 * ��ü ������ �Ҵ�, ������ GC-������ ��Ȯ�� ��
 * 
 * �޼ҵ�(����) ����: Ŭ���� ����
 * Ŭ���� �ε��� '�ѹ�' �Ҵ�, ���α׷� ����� ����
 */
