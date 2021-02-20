package com.ex0216;

public class Ex06 {

	public static void main(String[] args) {
		MyStack<String> ms=new MyStackImpl<>(5);
		ms.push("서울");
		ms.push("부산");
		ms.push("대구");
		
		while(!ms.isEmpty()) {
			System.out.println(ms.pop());
		}
		

	}

}

//배열을 이용한 스택 만들기
interface MyStack<E>{
	public E pop(); // top 데이터 반환하고 삭제
	public E peek(); // top 데이터 반환, 삭제 x
	public void push(E data);// 추가
	public boolean isEmpty(); // 비어있는지 확인
}

class MyStackImpl<E> implements MyStack<E>{
	
	private E[] elementData;
	private int top;
	
	@SuppressWarnings("unchecked")
	public MyStackImpl(int size) {
		elementData=(E[])new Object[size];
		top=0;
	}
	
	@Override
	public E pop() {
		if(isEmpty())
			throw new RuntimeException("stack empty");
		
		E item=peek();
		elementData[--top]=null;
		return item;
	}

	@Override
	public E peek() {
		if(isEmpty())
			throw new RuntimeException("stack empty");
		return elementData[top-1];
	}

	@Override
	public void push(E data) {
		if(top>=elementData.length)
			throw new RuntimeException("stack full");
		
		elementData[top++]=data;
	}

	@Override
	public boolean isEmpty() {
		
		return top<=0;
	}
	
}