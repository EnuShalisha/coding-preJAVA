package com.ex0215;

public class Ex2 {

	public static void main(String[] args) {
		MyList<String> list=new MyArrayList<String>();
		list.add("서울");
		list.add("부산");
		list.add("대구");
		
		MyIterator<String> it=list.iterator();
		while(it.hasNext()) {
			String s=it.next();
			System.out.print(s+" ");
		}
		System.out.println();

	}

}
