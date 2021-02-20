package com.ex0216;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class Ex04  {
	
	public static void main(String[] args) {
		
		//Stack: LIFO 구조
		Stack<String> st = new Stack<String>();
		//스택에 추가
		st.push("자바");
		st.push("오라클");
		st.push("서블릿");
		
		while(!st.isEmpty()) {
			String s=st.pop();
			System.out.println(s);
		}
		
		//Queue: FIFO 구조
		Queue<String> qu = new LinkedList<String>();
		qu.offer("서울");
		qu.offer("부산");
		qu.offer("대구");
		
		//Queue.peek: head요소를 반호ㅘㄴ하고 삭제 안함
		//pool: head요소를 반환하고 삭제함
		while(qu.peek()!=null) {
			String s=qu.poll();
			System.out.println(s);
		}
	}
	
}
