package com.ex0205;

public class Ex01 {

	public static void main(String[] args) // String[]얘도 파이널 클래스 - 파이널클래스는 자식생성 x
	{
		int []data= {15, 10, 7, 9, 25, 3, 8};
		
		SortInt ss=new Selectionsort();
		ss.sort(data);
		
		for(int n:data) {
			System.out.print(n+" ");
		}
		System.out.println();

	}

}

//추상클래스는 객체 생성 불가
//추상클래스는 하위 클래스 존재해야함
abstract class SortInt{
	private int[] value;
	
	protected abstract void sorting(); //사용자가 알아서 선택하도록 일부를 미완성시킴 - 추상메소드
	//일단 부모 클ㄹ래스에서 구현하지 않음 - 선언만 있고 정의가 없음
	
	public void sort(int[] value) {
		this.value = value;
		
		sorting();
	}
	
	protected int length() {
		int n=-1;
		if(value!=null)
			n=value.length;
		return n;
	}
	
	protected int compare (int i, int j) {
		return value[i]-value[j];
	}
	
	protected void swap(int i, int j) {
		int temp=value[i];
		value[i]=value[j];
		value[j]=temp;
	}
	
}

class Selectionsort extends SortInt{

	@Override
	protected void sorting() {
		for(int i=0; i<length()-1; i++) {
			for(int j=i+1; j<length(); j++) {
				if(compare(i, j)>0) {
					swap (i, j);
				}
			}
		}
		
	}
	
}

class Bubblesort extends SortInt{

	@Override
	protected void sorting() {
		
		
	}
	
	
}