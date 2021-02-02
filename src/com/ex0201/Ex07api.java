package com.ex0201;

public class Ex07api {

	public static void main(String[] args) {
		String s1="seoul";
		String s2="seoul";
		String s3=new String("seoul"); // �ڹٴ� new�� �ϸ� ������ �޸𸮸� �ٽ� ����
		
		System.out.println(s1+","+s2+","+s3);
		
		//��ü�� ������ �ؽ��ڵ�� ����
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		//�׷����� �ؽ��ڵ尡 ���ٰ� ���� ��ü�� �ƴ�
		System.out.println(s3.hashCode());
		
		s1+="�ѱ�"; // String�� �Һ��̴�?
		System.out.println(s1);
		System.out.println(s1.hashCode());
		System.out.println(s2);
		
		//���ڿ������� ==�� �ּҸ� ��
		System.out.println(s1==s2); 
		// �� ������? ���ڿ� �ѹ� �ּҸ� �Ҵ��ϸ� �ڹٴ� �ּҸ� ���� x
		System.out.println(s1==s3);
		//�� ��ü�� �ο��߱⶧���� �ּҸ� ����
		
		//���ڿ� �� ��
		System.out.println(s1.equals(s3));

	}

}
