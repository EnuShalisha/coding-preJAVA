package com.ex0223;

public class Ex02sync {

	public static void main(String[] args) {
		MyThread2 mt=new MyThread2();
		
		Thread t1= new Thread(mt);
		Thread t2= new Thread(mt);
		//메인 이외 2개 스레드
		
		t1.start();
		t2.start();
	}

}

//지원되는 애들: Hashtable, Stringbuffer, Vector
//동기화
class MyThread2 implements Runnable {
	private int money=10000;
	
	@Override
	public void run() {
		int m= 6000;
		int n=0;
		String msg=null;
		
		try {//동기화블럭
			synchronized (this) { // 첫 객체가 들어와있으면 두번째 객체는 들어오지 않도록
				if(getMoney()>=m) {
					Thread.sleep(200);
					n=drawMoney(m);
					msg="인출 성공";
				} else {
					n=0;
					msg="인출 실패";
				}	
			}
			System.out.println(msg+", 인출액: "+n+", 잔고:"+getMoney());
				
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