package com.ex0125;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String o=""; //String형으로 정의된 것에 주목
		z: //z:는 라벨명이다
		for(int x=0; x<3; x++) {
		    for(int y=0; y<2; y++) { // y=2면 위 for문으로 back
		        if(x==1) break; // x=1 되자마자 for문 break
		        if(x==2 && y==1) break z; // 20까지는 밑에 연산, 21은 z for문 break
		        o=o+x+y; // xy = 00, 01, 20
		    }
		}
		}
	    }
	


