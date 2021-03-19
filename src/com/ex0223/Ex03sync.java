package com.ex0223;

public class Ex03sync {

	public static void main(String[] args) {
		MyData1 share = new MyData1();
		
		UpThread1 up = new UpThread1(share, "up 전");
		DownThread1 down = new DownThread1(share, "down 전");
		
		
		up.start();
		down.start();
	}

}

class MyData1 {
	private int val=100;
	
	public void up(String title) {
		System.out.print(title+":"+val);
		val++;
		System.out.println(", 증가 후"+val);
	}
	
	public void down(String title) {
		System.out.print(title+":"+val);
		val--;
		System.out.println(", 감소 후"+val);
	}
}

class UpThread1 extends Thread{
	private MyData1 share;
	private String title;
	
	public UpThread1(MyData1 share, String title) {
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

class DownThread1 extends Thread{
	private MyData1 share;
	private String title;
	
	public DownThread1(MyData1 share, String title) {
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