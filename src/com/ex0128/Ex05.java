package com.ex0128;

public class Ex05 {

	public static void main(String[] args) {
		Test5 ob=new Test5();
		int a=10;
		//call by value
		ob.sub(a);
		System.out.println("Main:"+a); // sub에서의 a와 main에서 선언됐던 a는 다르다 / 다른주소
		
		
		System.out.println(ob.x); // 0 - 값이 초기상태
		//call by reference
		ob.sub2(ob); 
		System.out.println(ob.x);
		
		int[] aa= {1, 2, 3, 4, 5};
		System.out.println(aa[2]);
		
		ob.sub3(aa); // 이것도 call by reference
		System.out.println(aa[2]);
		
	}

}

class Test5{
	int x;
	public void sub (int a) {
		a++;
		System.out.println("sub:"+a);}
	public void sub2(Test5 tt) { // 이것은 값을 전달하는게 아니라 참조위치-주소-를 보내는것이여
		tt.x=20; //그 주소에 x값은 20이 되는것이고
	}
	public void sub3(int[] a) {
		a[2]=20;
	}

}