package com.ex0223;

public class Ex01sync {

	public static void main(String[] args) {
		MyThread mt=new MyThread();
		
		Thread t1= new Thread(mt);
		Thread t2= new Thread(mt);
		//메인 이외 2개 스레드
		
		t1.start();
		t2.start();
	}

}

class MyThread implements Runnable {
	private int money=10000;
	
	@Override
	public void run() {
		int m= 6000;
		int n=0;
		String msg=null;
		
		try { //가장 큰 문제점
			if(getMoney()>=m) {
				Thread.sleep(200);
				n=drawMoney(m);
				msg="인출 성공";
			} else {
				n=0;
				msg="인출 실패";
			}System.out.println(msg+", 인출액: "+n+", 잔고:"+getMoney());
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int getMoney() {
		return money;
	}
	
	private int drawMoney(int m) {
		money -= m;
		return m;
	}
}