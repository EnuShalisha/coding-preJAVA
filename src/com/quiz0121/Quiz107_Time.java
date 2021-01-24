package com.quiz0121;
public class Quiz107_Time {
	public static void main(String[] args) {
/*		
		x는 100부터 시작해서 1초마다 2씩 증가하고 y는 0부터 시작해서 1초마다 5씩 증가 한다.
		몇 초 후에 y가 x를 따라 잡는지와 따라 잡았을 때 x와 y의 값
*/
		int x=100, y=0;
		int s=0;
		
		while(x>=y) {
			s++;
			x+=2;
			y+=5;
		}
		
		System.out.println("x : "+ x +", y : " + y);
		System.out.println("걸린시간 : " + s +"초");
	}
}
