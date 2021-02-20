package com.ex0217;

import java.io.PrintWriter;

public class Ex09pw {

	public static void main(String[] args) {
		//PrintStream: 바이트스트림 // PrinterWriter: 문자 스트림
		
		//프린트스트림을 프린트라이터로 바꾼 경우
		//예외처리 필요 x
		/*PrintWriter pw=new PrintWriter(System.out);
		pw.print("자바");
		pw.print("오라클");
		pw.println("웹");
		pw.flush();//문자스트림이기 때문-버퍼 flush
		*/
		//true 옵션 추가시 flush()나 println() 호출시 출력
		//근데 그냥 writer는 문자스트림이라 flush한다 생각하면 마음 편함
		PrintWriter pw=new PrintWriter(System.out, true);
		pw.print("자바");
		pw.print("오라클");
		pw.println("웹");
	}

}
