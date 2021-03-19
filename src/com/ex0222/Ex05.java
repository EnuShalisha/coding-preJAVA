package com.ex0222;

public class Ex05 {

	public static void main(String[] args) {
		MyThread03 t1=new MyThread03();
		MyThread03 t2=new MyThread03();
		MyThread03 t3=new MyThread03();
		
		//daemon thread: 다른 스레드에 도움을 주기 위한 스레드 - 메인 스레드 종료되면 종료
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
		
		//우선순위 - 무조건 보장받는건 또 아님
		t1.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join(); // 다른 쓰레드가 종료할 때까지 종료 안하고 대기
			t2.join();
			t3.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("main end");
		

	}

}

class MyThread03 extends Thread {
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(getName()+"-"+i);
			try {
				sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}