package com.ex0201;

public class Ex01 {

	public static void main(String[] args) {
		Test1 t = new Test1();
		System.out.println(t.sum(1, 2, 3, 4, 5));
		System.out.println(t.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	}

}

class Test1{
	public int sum(int ... n) {
			int s=0;
			/*for(int i=0; i<n.length; i++) {
				s+=n[i]; // ���������� �迭 ó��
			}*/
			
			for(int a:n) {
				s+=a;
			}
			return s;
	}
}