package com.ex0126;

public class Exam01 {

	public static void main(String[] args) {
		/*■ 자바 테스트

		오류인 경우 컴파일 오류인지 런타임 오류 인지와 이유를 간단히 기술하세요

		1] 실행 결과는 ?  : 컴파일 오류; int x[]=new int[3];
		int x[3];
		x[0]=1; x[1]=2; x[2]=3;
		int s=0;
		for(int a:x)
		  s+=a;
		System.out.println(s);


		2] 실행 결과는 ? : :컴파일 오류; 위와 동일
		int x[5] = {1,2,3,4,5};
		int s=0;
		for(int a:x)
		  s+=a;
		System.out.println(s);


		3] 실행 결과는 ? : 6
		int x[] = new int[]{2,4,6,8,10};
		System.out.println(x[2]);


		4] 실행 결과는 ?  :컴파일 오류; 5를 고칠수 읎음
		int x[] = new int[5]{1,3,5,7,9};
		int s=0;
		for(int a:x)
		  s+=a;
		System.out.println(s);


		5] 실행 결과는 ? 10
		int x[] = new int[10];
		System.out.println(x.length);


		6] 실행 결과는 ? 런탐오류) 5가 어딨냐
		int x[] = {1,3,5,7,9};
		System.out.println(x[5]);


		7] 실행결과는 ? : 0
		int x[] = new int[5];
		System.out.println(x[3]);


		8] 다음 실행 결과는 ? 4 5
		int [][] b = new int[4][5]; 
		System.out.println(b.length);
		System.out.println(b[1].length);


		9] 다음 실행 결과는 ? 3 2
		int[][] b = { { 1, 2, 3 }, { 1, 2 }, { 1, 2, 3, 4 } };
		System.out.println(b.length);
		System.out.println(b[1].length);


		10] 다음의 실행 결과는 ? 0
		int []a={2,4,6,8,10};
		a=new int[10];
		System.out.println(a[2]);


		11] 다음중 올바른것을 모두 고르면 ? 
		가. int[] ia = new int[15]; o
		나. float fa = new float[20]; : 타입 미스매치? 배열이 없네 ㅎ
		다. char[]ca = "Some String"; x
		라. int a[][] = {4, 5, 6} {1, 2, 3}; x


		12] 실행 결과는 ? 0.0
		float f1[], f2[];
		f1 = new float[10];
		f2 = f1;
		System.out.println(f2[0]);


		13] 컴파일 오류가 발생하는 것을 모두 고르면 ?
		가. int[] scores = {3, 5, 7}; o
		나. int[][] scores = {2, 7, 6},{9, 3, 45}; 컴팔오류
		다. String cats[] = {"Fluffy", "Spot", "Zeus"}; o
		라. boolean results[] = new boolean[3] {true, false, true}; 컴팔오류
		마. String[] dogs = new String[] {"Fido", "Spike","Aiko"}; o


		14] 다음 실행 결과는 ? 3
		int []x= {1,2,3,4, 5};
		int y[] =x;
		System.out.println(y[2]);


		15] 실행 결과는 ? 130
		int a1[], a2[];
		a1 = new int[5];
		a2 = a1;
		a1[0]=20; a1[1]=30; a1[2]=40; a1[3]=50; a1[4]=60;
		a2[1]+=100;
		System.out.println(a2[1]);


		16] 다음 프로그램을 2 3 4
		public class Test{
		  public static void main(String[] args){
		     for(int x=1; x<args.length; x++){
		       System.out.print(args[x] + "");
		     }
		   }
		}

		다음과 같이 컴파일과 실행했을 경우

		java Test 1 2 3 4

		실행 결과 ?*/




	}

}
