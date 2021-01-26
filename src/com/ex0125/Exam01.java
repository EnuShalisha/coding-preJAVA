package com.ex0125;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		String a[] = {"¿ø¼şÀÌ", "´ß", "°³", "µÅÁö", "Áã", "¼Ò", "È£¶ûÀÌ", "Åä³¢", "¿ë", "¹ì", "¸»", "¾ç"};
		Scanner sc= new Scanner(System.in);
		System.out.println("¿¬µµ ÀÔ·Â: ");
		int y=sc.nextInt();
		int n=y%12;
		System.out.printf("%d³âÀÇ ¶ì´Â %s¶ìÀÔ´Ï´Ù.", y, a[n]);
		sc.close();
	}

	}


