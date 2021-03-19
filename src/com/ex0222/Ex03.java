package com.ex0222;

public class Ex03 {

	public static void main(String[] args) {
		try {
			System.out.println("main-"+i);
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("main end");
		//멀티 스레드 환경에서 main은 프로그램의 시작점이지 종료점은 아님
		//멀티 스레드 환경에서는 모든 스레드 종료돼야 프로그램 종료
	}

}

class MyThread01 extends Thread {
	@Override
	public void run() {
	int i=0;
	
	try {
		while(i<20) {
			i++;
			System.out.println(getName()+"-"+i);
			
			sleep(500);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
}