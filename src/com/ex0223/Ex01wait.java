package com.ex0223;

public class Ex01wait {

	public static void main(String[] args) {
		MyBank atm = new MyBank();
		Thread t1 = new Thread(atm, "홍대");
		Thread t2 = new Thread(atm, "강남");
		
		t1.start();
		t2.start();

	}

}

class MyBank implements Runnable {
	private long money=10000;
	
	@Override
	public void run() {
		synchronized (this) {//현재 객체 동기화
			for(int i=0; i<10; i++) {
				if(getMoney()<=0) {
					this.notifyAll();
					break;
				}
				drawMoney(1000);
				
				if(getMoney()%2000==0) {
					try {
						this.wait(); // 다른 스레드도 일할 수 있게 하는 방법
						//싱크 블럭에서만 사용 가능
						//notify 호출할 때 까지 멈추고 -> 다른 스레드에게 제어권 넘어감
					} catch (InterruptedException e) {
					}
				} else {
					this.notify();
				}
			}
		}
	}
	
	public long getMoney() {
		return money;
	}
	
	public void drawMoney(int m) {
		String s=Thread.currentThread().getName();
		System.out.println("현재 스레드: "+s+", ");
		
		if(getMoney()>=m) {
			money-=m;
			System.out.println("잔액: "+getMoney());
		}else {
			System.out.println("잔고 부족...");
		}
	}
}