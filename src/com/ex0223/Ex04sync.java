package com.ex0223;

public class Ex04sync {

	public static void main(String[] args) {
		MyData2 share = new MyData2();
		
		UpThread2 up = new UpThread2(share, "up 전");
		DownThread2 down = new DownThread2(share, "down 전");
		
		
		up.start();
		down.start();
	}

}
//동기화 메소드
class MyData2 {
	private int val=100;
	
	public synchronized void up(String title) {
		System.out.print(title+":"+val);
		val++;
		System.out.println(", 증가 후"+val);
	}
	
	public synchronized void down(String title) {
		System.out.print(title+":"+val);
		val--;
		System.out.println(", 감소 후"+val);
	}
}

class UpThread2 extends Thread{
	private MyData2 share;
	private String title;
	
	public UpThread2(MyData2 share, String title) {
		this.share=share;
		this.title=title;
	}
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			try {
				sleep(500);
				share.up(title);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
}

class DownThread2 extends Thread{
	private MyData2 share;
	private String title;
	
	public DownThread2(MyData2 share, String title) {
		this.share=share;
		this.title=title;
	}
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			try {
				sleep(500);
				share.down(title);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
}