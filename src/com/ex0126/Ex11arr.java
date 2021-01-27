package com.ex0126;

public class Ex11arr {

	public static void main(String[] args) {
		
		/*실행
		 * cmd>java Ex11arr
		 * cmd>java Ex11arr a b c
		 * main 함수의 args[0]='a', [1]='b' [2]='c'
		 * cmd>java Ex11arr x y
		 * args[0]='x', [1]='y'
		 * 커맨드에서 실행한다. 명령행 인수.
		 */
		for(int i=0; i<args.length; i++)
			System.out.println(args[i]);
	}

}
