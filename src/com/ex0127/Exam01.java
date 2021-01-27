package com.ex0127;

public class Exam01 {

	public static void main(String[] args) {
		T t1 = new T();
		System.out.println(t1.upper('&'));
		
		System.out.println(t1.isup('&'));
		
		System.out.println(t1.max(3, 5));
		
		t1.triangle(5);
		
		System.out.println(t1.grade(84));
	}

}

class T{
public char upper(char c) {
	// return c>='a'&&c<='z'? (char)(c-32) : c;
	if (c>='a'&&c<='z') {
		c-=32;
		return c;
	}
	else
		return '0';
}
public boolean isup(char c) {
	return c>='A'&&c<='Z'? true : false;
}

public int max(int a, int b) {
	return a>b? a: b;
}

public void triangle (int n) {
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=n-i; j++) System.out.print(" ");
		for(int j=1; j<=i*2-1; j++) System.out.print("*");
		System.out.println();
	}
}
public double grade(int score) {
	if (score>=95) 		return 4.5;
	else if(score>=90) 	return 4.0;
	else if(score>=85) 	return 3.5;
	else if(score>=80) 	return 3.0;
	else if(score>=75) 	return 2.5;
	else if(score>=70) 	return 2.0;
	else if(score>=65) 	return 1.5;
	else if(score>=60) 	return 1.0;
	else 				return 0.0; // 리턴이 없으면 오류
}

}