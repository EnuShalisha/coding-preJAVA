package com.ex0127;

public class Exam02 {

	public static void main(String[] args) {
	
		System.out.println(Test.grade(76));
		// System.out.println(Test.dan(10)); 보이드 메소드는 sysout 못하게돼있음
		System.out.println(Test.dan(10)); // 리턴값 없음
		System.out.println(Test.dan(9));
		
		System.out.println(Test.sum(3, 5));
		System.out.println(Test.sum(10, 1));
		
	}

}
class Test{
	public static String grade(int score) {
	switch(score/10){
	case 10:
	case 9: return "A"; // 어차피 여기에 break가 포함
	case 8: return "B";
	case 7: return "C";
	case 6: return "D";
	default: return "F";
	}
	
	}
	
	public static String dan(int num) {
		String out="";
		if(num>=1&&num<=9) {
			for(int i=1; i<=9; i++) 
				out=out+i+"*"+num+"="+i*num+"\n";
		return out; // 이렇게 리턴값으로 짜주는 것이 나중에 다른 메소드와 함께 채용할 때 훨씬 범용성이 높음
		}
		else return "오류";
	}
	public static int sum(int a, int b) {
		int s=0;
		int temp=0;
		if(a>b) {
			temp=a; b=a; a=temp;
		}
		/*if(a>b) {
			for(int i=b; i<=a; i++) s+=i;
			
		}
		else {*/
			for(int i=a; i<=b; i++) s+=i;
		return s;
	}
}
