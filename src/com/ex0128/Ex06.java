package com.ex0128;

public class Ex06 {

	public static void main(String[] args) {
		Test6 t = new Test6();
		t.print(5);
		System.out.println();// 출력 -> 1 2 3 4 5 이래서 스텍메모리 아

	}

}
class Test6 {
	public void print(int n) { 
		if(n>1) // 이게 없으면 stack overflow - 메모리의 stack영역을 사용하기때문에 무한정 x
			print(n-1); // 스택메모리 -> 5 4 3 2 입력
		System.out.print(n+" "); // 1 출력 -> 나머지 끄집어냄 2 3 4 5
	}
}