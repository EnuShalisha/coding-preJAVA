package com.ex0215;

public interface MyList<E> {
	//데이터 추가
	public void add(E element);
	//데이터 추가
	public boolean add(int index, E element);
	//특정 인덱스 데이터 반환
	public E get(int index);
	//특정 인덱스의 데이터 수정
	public E set(int index, E element);
	//요소의 개수
	public int size();
	//특정 인덱스의 데이터 지우기
	public E remove(int index);
	//특정 데이터 지우기
	public boolean remove(E element);
	//모두 지우기
	public void clear();
	//특정 데이터의 인덱스 구하기
	public int indexOf(E element);
	//버퍼의 크기를 요소의 개수로 조정
	public void trimToSize();
	//반복자
	public MyIterator<E> iterator();
	
	
}
