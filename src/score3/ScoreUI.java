package score3;

import java.util.Scanner;

public class ScoreUI extends Score{
	private Scanner sc = new Scanner(System.in);
	
	
	public void menu() {
		int ch;
		while(true) {
			do {
				System.out.println("1. 입력 2. 수정 3. 삭제 4. 리스트");
				System.out.println("5. 평점 6. 이름검색 7. 학번검색 8. 종료");
				ch=sc.nextInt();
			}while(ch<1||ch>8);
		
		if(ch==8) {
			System.exit(0); // 프로그램 강제 종료
		}
		
		switch(ch) {
		case 1: input(); break;
		case 2: update(); break;
		case 3: delete(); break;
		case 4: print(); break;
		case 5: printGrade(); break;
		case 6: findbyName(); break;
		case 7: findbyHak(); break;
		}
		}
	}
	
	public void input() {
		System.out.println("\n자료 입력");
		
		ScoreVO vo = new ScoreVO();
		
		System.out.print("학번?");
		vo.setHak(sc.next());
		if(readScore(vo.getHak())!=null) {
			System.out.println("이미 등록된 학번");
			return;
		}
		
		System.out.print("이름?");
		vo.setName(sc.next());
		System.out.print("국어?");
		vo.setKor(sc.nextInt());
		System.out.print("수학?");
		vo.setMat(sc.nextInt());
		System.out.print("영어?");
		vo.setEng(sc.nextInt());
		
		append(vo);
		System.out.println("등록완료");
	}
	
	public void update() {
		System.out.println("\n자료 수정");
		
		System.out.println("학번?");
		String hak=sc.next();
		ScoreVO vo = readScore(hak);
		if(vo==null) {
			System.out.println("존재하지 않는 학번");
			return;
		}
		
		System.out.print("이름?");
		vo.setName(sc.next());
		System.out.print("국어?");
		vo.setKor(sc.nextInt());
		System.out.print("수학?");
		vo.setMat(sc.nextInt());
		System.out.print("영어?");
		vo.setEng(sc.nextInt());
		
		System.out.println("수정 완료");
	}
	
	public void delete() {
		System.out.println("\n자료 삭제");
		
		System.out.println("학번 입력");
		String hak=sc.next();
		
		if(!remove(hak)) {
			System.out.println("등록되지 않은 학번");
			return;
		}
		
		System.out.println("삭제 완료");
		
	}
	
	public void print() {
		System.out.println("\n전체 리스트");
		
		ScoreVO[] list = listScore();
		for(int i=0; i<getCount(); i++) 
			System.out.println(list[i]);//=toString(list[i])
		//override된 toString으로 인해 모든 필드가 프린트로 찍힘.
		System.out.println();
	}
	
	public void printGrade() {
		System.out.println("\n평점 출력");
		
		ScoreVO[] list = listScore();
		for(int i=0; i<getCount(); i++) {
			System.out.print(list[i].getHak()+"\t");
			System.out.print(list[i].getName()+"\t");
			System.out.print(grade(list[i].getKor())+"\t");
			System.out.print(grade(list[i].getMat())+"\t");
			System.out.print(grade(list[i].getEng())+"\t");
			System.out.println();
		}
		
	}
	
	public void findbyName() {
		System.out.println("\n이름 검색");
		
		String name;
		System.out.print("검색할 이름?");
		name=sc.next();
		
		
		ScoreVO[] list=listScore();
		for(int i=0; i<getCount(); i++) {
			if(list[i].getName().indexOf(name)>=0) 
				System.out.println(list[i]);	
		}
	}
	
	public void findbyHak() {
		System.out.println("\n학번 검색");
		
		String hak;
		System.out.print("검색할 학번?");
		hak=sc.next();
		
		ScoreVO vo = readScore(hak);
		if(vo==null) {
			System.out.println("등록되지 않은 학번");
			return;
		}
		
		System.out.println(vo);
		System.out.println();
	}
}
