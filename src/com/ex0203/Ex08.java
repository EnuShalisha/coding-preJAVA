package com.ex0203;

import java.text.ChoiceFormat;

public class Ex08 {

	public static void main(String[] args) {
		double[] limits = {0, 60, 70, 80, 90}; // 적은 수에서 큰수순으로 해야함
		String[] grades = {"F", "D", "C", "B", "A"};
		ChoiceFormat cf = new ChoiceFormat(limits, grades);
		
		System.out.println("95:"+cf.format(95));
		System.out.println("75:"+cf.format(75));
		System.out.println("55:"+cf.format(55));
		
		String p="0#F|60#D|70#C|80<B|90#A"; // 한줄로 나타낸 형식 #는 등호포함 <는 미포함
		ChoiceFormat cf2=new ChoiceFormat(p);
		
		System.out.println("95:"+cf2.format(95));
		System.out.println("80:"+cf2.format(80));
		System.out.println("75:"+cf2.format(75));
		System.out.println("55:"+cf2.format(55));
	}

}
