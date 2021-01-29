package com.ex0129;

public class Ex01 {

	public static void main(String[] args) {
		Test1 vo = new Test1();
		
		
		vo = new Test1();
		vo.setName("aa");
		vo.append(vo);
		
		vo.setName("bb");
		vo.append(vo);
		
		for(int i=0; i<vo.getCount(); i++) {
			Test1 t = vo.listTest()[i];
			System.out.println(t.getName());
		}
		
		
	}

}

class Test1 {
	private String name;
	
	private Test1[] list = new Test1[10];
	
	private int count;
	
	public int append(Test1 vo) {
		if(count>=10)
			return -1;
		list[count++] = vo;
		return count;
	}
	
	public int getCount() {
		return count;
	}
	public Test1[] listTest() {
		return list;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}