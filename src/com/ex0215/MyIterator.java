package com.ex0215;

public interface MyIterator<E> {
	public boolean hasNext();
	public E next();
	public void remove();
}
