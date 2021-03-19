package com.ex0222;
//쓰레드 생성 두번째 방법
public class Ex04 {

	public static void main(String[] args) {
		MyThread02 tt=new MyThread02();
		Thread t=new Thread(tt); //thread 생성자에 runnable 구현객체를 대입
		
		t.start();
		
		for(int i=1; i<=5; i++) {
			System.out.println("메인-"+i);
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("main end");

	}

}

class MyThread02 implements Runnable{

	@Override
	public void run() {
		int i=0;
		
		try {
			while(i<10) {
				i++;
				System.out.println(Thread.currentThread().getName()+"-"+i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}