package score1;

import java.util.Scanner;

public class Score {
	private Scanner sc = new Scanner(System.in);
	ScoreVO vo = new ScoreVO(); // 이러면 input 메소드 print 메소드 다 사용 가능
	public void input() {
		System.out.println("데이터 입력..");
		
		
		System.out.print("이름?");
		vo.name = sc.next();
		
		System.out.print("국어?");
		vo.kor=sc.nextInt();
		System.out.print("영어?");
		vo.eng=sc.nextInt();
		System.out.print("수학?");
		vo.mat=sc.nextInt();
	}
	public void print( ) {
		System.out.println("데이터 출력..");
		System.out.print(vo.name+"\t");
		System.out.print(vo.kor+"\t");
		System.out.print(vo.eng+"\t");
		System.out.print(vo.mat+"\t");
		System.out.print(vo.tot()+"\t");
		System.out.println(vo.ave());
	}
	
	public void printgrade() {
		System.out.println("평점 출력..");
		
		System.out.print(vo.name+"\t");
		System.out.print(vo.kor+"\t");
		System.out.print(vo.eng+"\t");
		System.out.print(vo.mat+"\t");
		System.out.println(vo.grade((int)vo.ave()));
	}
	
	//sc.close(); 쓰지 않는다!! 다른 클래스에서 선언됐을 때 입력을 못함!
}
