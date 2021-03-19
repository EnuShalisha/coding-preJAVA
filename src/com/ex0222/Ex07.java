package com.ex0222;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Ex07 {

	public static void main(String[] args) {
		new MyTimer();

	}

}

class MyTimer {
	public MyTimer() {
		//TimerTask: 타이머에 의해 1회 또는 반복 실행하도록 테스크되는 스케줄
		//단점: 시간이 지연될 수 있음(0.001~0.002초. 많은 스레드 실행, GC에 의해)
		TimerTask task= new TimerTask() {//timer-timertask 페어링
			
			@Override
			public void run() {
				print();
			}
		}; 
		
		Timer timer=new Timer();
		//timer.schedule(task, 2000, 1000); //2초 후 1초 마다 한번 실행
		//timer.schedule(task, new Date(), 1000); //바로 실행하며 1초마다 반복
		
		//다음날 0시 0분 0초부터 매일
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		timer.schedule(task, cal.getTime(), 1000*60*60*24);
	}
	
	public void print() {
		Calendar cal = Calendar.getInstance();
		String s=String.format("%tF %tT", cal, cal);
		System.out.println(s);
	}
}
