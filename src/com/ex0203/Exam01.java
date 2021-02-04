package com.ex0203;

import java.util.Random;
import java.util.Scanner;

public class Exam01 {
Exam01VO vo= new Exam01VO();

public Exam01VO toNumber3() {
	StringBuilder sb=new StringBuilder();
	Random rd=new Random();
	String n;
	String carr[]=new String[3];
	for(int i=0; i<3; i++) {
		n=Integer.toString(rd.nextInt(9)+1);
		if(sb.indexOf(n)>=0) {
			i--;
			continue;
		}
		carr[i]=n;
		sb.append(n);
	}
	vo.setCarr(carr);	
	vo.setCom(sb.toString());
	return vo;
}

public Exam01VO input(String sc) {
	String uarr[] =sc.split("");
	for(int i=0; i<3; i++) {
		if(sc.indexOf(uarr[i])<i)
			return null;
	}
	vo.setUarr(uarr);
	return vo;
}

public Exam01VO compare(Exam01VO vo) {
	String carr[]=vo.getCarr();
	String uarr[]=vo.getUarr();
	String com=vo.getCom();
	String user=vo.getUser();
	int hit=0, strike=0, ball=0;
	for(int i=0; i<3; i++) {
		if(com.indexOf(uarr[i])>=0) {
			if(uarr[i].equals(carr[i]))
				hit++;
			else ball++;
		}
		else strike++;
	}
	vo.setHit(hit); vo.setStrike(strike); vo.setBall(ball);
	return vo;
	
}
}