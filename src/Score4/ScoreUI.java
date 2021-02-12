package Score4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import score2.ScoreVO;

public class ScoreUI {
	private Scanner sc = new Scanner(System.in);
	private ScoreImpl ss =new ScoreImpl();
	
	public void menu() {
		int ch;
		
		while(true) {
			try {
				do {
					System.out.println("1. 등록 2. 수정 3. 삭제 4. 학번검색 5. 이름검색 6. 리스트 7. 종료 => ");
					ch=sc.nextInt();
				} while(ch<1 || ch>7);
				
				if(ch==7) {
					return;
				}
				switch(ch) {
				case 1: append(); break;
				case 2: update(); break;
				case 3: delete(); break;
				case 4: findByHak(); break;
				case 5: findByName(); break;
				case 6: list(); break;
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
			}
		}
	}
	public void append() {
		System.out.println("추가");
		ScoreVO vo = new ScoreVO();
		try {
			System.out.print("학번?");
			vo.setHak(sc.next());
			System.out.print("이름?");
			vo.setName(sc.next());
			System.out.print("국어?");
			vo.setKor(sc.nextInt());
			System.out.print("수학?");
			vo.setMat(sc.nextInt());
			System.out.print("영어?");
			vo.setEng(sc.nextInt());
			
			boolean b = ss.insertScore(vo);
			if(b)
				System.out.println("추가 성공");
			else
				System.out.println("학번 중복으로 추가 실패");
			
		} catch (InputMismatchException e) {
			System.out.println("점수는 숫자만 입력 가능");
			sc.nextLine();
		}
		System.out.println();
	
	}
	
	public void update() {
		System.out.println("수정");
		ScoreVO vo = new ScoreVO();
		
		System.out.println("수정할 학번?");
		vo=ss.readScore(sc.next());
		if(vo==null)
			{System.out.println("존재하지 않는 학번");
			return;
		}
		
		while(true) {
		try {
			System.out.print("이름?");
			vo.setName(sc.next());
			System.out.print("국어?");
			vo.setKor(sc.nextInt());
			System.out.print("수학?");
			vo.setMat(sc.nextInt());
			System.out.print("영어?");
			vo.setEng(sc.nextInt());
			System.out.println("수정 완료");
			break;
		} catch (InputMismatchException e) {
			System.out.println("점수는 숫자만 입력 가능");
			sc.nextLine();
		}
		System.out.println();
		}
	}
	
	public void delete() {
		System.out.println("삭제");
		
		String hak;
		System.out.println("삭제할 학번?");
		hak=sc.next();
		
		if(ss.deleteScore(hak)) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제실패");
		}
	System.out.println();
	}
	
	public void findByHak(){
		System.out.println("학번으로 찾기");
		
		String hak;
		System.out.println("찾을 학번?");
		hak=sc.next();
		
		if(ss.readScore(hak)==null)
			{System.out.println("존재하지 않는 학번");
			return;
			}
		
		System.out.println(vo.getHak()+"\t");
		
	}
	
	public void findByName(){
		System.out.println("이름 검색");
	
		String name;
		name=sc.next();
		
		List<scoreVO> list=ss.listScore(name);
		if(list.size()==0) {
			System.out.println("등록된 자료가 없습니다.");
			return;
		}
		
		for(ScoreVO vo:list) {
			System.out.println(vo.getHak()+"\t");
		}
		System.out.println();
	}
	
	
	public void list() {
		System.out.println("\n전체리스트");
		
		for(ScoreVO vo : ss.listScore()) {
			System.out.print(vo.getHak()+"\t");
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getKor()+"\t");
			System.out.print(vo.getEng()+"\t");
			System.out.print(vo.getMat()+"\t");
			System.out.print(vo.getTot()+"\t");
			System.out.print(vo.getAve()+"\n");
		}
		System.out.println();
	}
}
