package com.ex0215;

public class MyArrayList<E> implements MyList<E> {
	private Object[] elementData;
			//어차피 제너릭은 들어가면 object형태
	private int size;
	
	public MyArrayList() {
		allocation(10);
	}
	public MyArrayList(int capacity) {
		allocation(capacity);
	}
	
	private void allocation(int capacity) {
		Object[] temp=new Object[capacity];
		if(elementData!=null&&size>0) {
			System.arraycopy(elementData, 0, temp, 0, size);
		}
	}
	
	@SuppressWarnings("unchecked")
	private E elementData(int index) {
		return (E)elementData[index];
	}
	
	@Override
	public void add(E element) {
		if(size>=elementData.length)
			allocation(elementData.length+10);
		elementData[size++]=element;
		
	}

	@Override
	public boolean add(int index, E element) {
		if(index<0||index>size)
			return false;
		if(size>=elementData.length)
			allocation(elementData.length+10);
		
		for(int i=size-1; i>=index; i--)
			elementData[i+1]=elementData[i];
		
		elementData[index]=element;
		size++;
		return true;
	}

	@Override
	public E get(int index) {
		if(index<0||index>=size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}//배열 인덱스 넘쳤을경우 나오는 에러
		return elementData(index);
	}

	@Override
	public E set(int index, E element) {
		if(index<0||index>=size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		E old=elementData(index);
		elementData[index]=element;
		return old;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E remove(int index) {
		if(index<0||index>=size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E removed=elementData(index);
		for(int i=index+1; i<=size-1; i++) {
			elementData[i-1]=elementData[i];
		}
		size--;
		elementData[size]=null;
		return removed;
	}

	@Override
	public boolean remove(E element) {
		for(int i=0; i<size; i++) {
			if(elementData[i].equals(element)) { //스트링때무네 ==는 안대여
				remove(i);
				return true;
		}
		}return false;
	}

	@Override
	public void clear() {
		for(int i=0; i<size; i++)
			elementData[i]=null;
		size=0;
	}

	@Override
	public int indexOf(E element) {
		for(int i=0; i<size; i++) {
			if(elementData[i].equals(element))
				return i;
		}
		return -1;
	}

	@Override
	public void trimToSize() {
		allocation(size);
		
	}

	@Override
	public MyIterator<E> iterator() {
		return new MyIteratorImpl();
	}
	
	private class MyIteratorImpl implements MyIterator<E> {
		private int nextIndex=0;
		@Override
		public boolean hasNext() {
			return nextIndex<size();
		}

		@Override
		public E next() {
			return elementData(nextIndex++);
		}

		@Override
		public void remove() {
			MyArrayList.this.remove(nextIndex-1);
			//외부 클래스의 this 처리는 이렇게
			nextIndex--;
			
		}
		
	}

	@Override
	public String toString() {
		String s="[";
		for(int i=0; i<size; i++) {
			s+=elementData[i];
			if(i<size-1)
				s+=",";
			}
		return s+"]";
		}
	}
	
	

