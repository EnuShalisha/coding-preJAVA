package com.ex0222;

public class Ex06 {

	public static void main(String[] args) {
		MyThread04 t=new MyThread04();
		t.start();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//이제 무한루프에 대해 인터럽트
		t.interrupt();
		//sleep에서 interrupt를 만나면 interruptedexception 발생
		
		System.out.println();

	}

}

class MyThread04 extends Thread{
	@Override
	public void run() {
		int i=0;
		try {
			while(true) {
				i++;
				System.out.println("스레드- "+i);
				sleep(500);
			}
		} catch (Exception e) {
			System.out.println("인터럽트");
		}
		System.out.println("스레드 종료");
	}
}