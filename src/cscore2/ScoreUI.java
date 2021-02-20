package cscore2;

import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ScoreUI {
	private Scanner sc=new Scanner(System.in);
	private Score score=new ScoreImpl();
	
	public void menu() {
		int ch;
		while(true) {
			try {
				do {
					System.out.print("1. 등록 2. 수정 3. 삭제 4. 리스트 "
							+ "5. 학번검색 6. 이름검색 7. 종료=>");
					ch=sc.nextInt();
				} while(ch<1||ch>7);
			if(ch==7) {
				System.exit(0);
			}
			
			switch(ch) {
			case 1:input(); break;
			case 2:update(); break;
			case 3:delete(); break;
			case 4:list(); break;
			case 5:findByHak(); break;
			case 6:findByName(); break;
			}
		} catch (InputMismatchException e) {
			sc.nextLine();
		}
		}
	}
	
	
	
	public void input() {
		System.out.println("등록");
		try {
			String hak;
			ScoreVO vo =new ScoreVO();
			
			System.out.print("학번?");
			hak=sc.next();
			
			System.out.print("이름?");
			vo.setName(sc.next());
			
			System.out.print("국어?");
			vo.setKor(sc.nextInt());
			
			System.out.print("영어?");
			vo.setEng(sc.nextInt());
			
			System.out.print("수학?");
			vo.setMat(sc.nextInt());
			
			if(!score.insertScore(hak, vo))
				System.out.println("등록 실패");
			else
				System.out.println("등록 완료");
		} catch (InputMismatchException e) {
			System.out.println("점수는 숫자만 가능합니다.");
			sc.nextLine();
		}
	}
	
	public void update() {
		System.out.println("수정");
		
		String hak;
		try {
			System.out.println("학번?");
			hak=sc.next();
			ScoreVO vo=score.readScore(hak);
			if(vo==null) {
				System.out.println("존재하지 않는 학번입니다.");
				return;
			}
			System.out.print("이름?");
			vo.setName(sc.next());
			
			System.out.print("국어?");
			vo.setKor(sc.nextInt());
			
			System.out.print("영어?");
			vo.setEng(sc.nextInt());
			
			System.out.print("수학?");
			vo.setMat(sc.nextInt());
			
			System.out.println("수정 완료?");
			
		} catch (InputMismatchException e) {
			System.out.println("점수는 숫자만 입력가능");
		}
	}
	
	public void delete(){
		System.out.println("삭제");
		
		System.out.print("삭제할 학번?");
		String hak=sc.next();
		
		if(score.deleteScore(hak)) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("등록된 학번 아님");
		}
	}
	
	public void list() {
		System.out.println("리스트");
		
		Map<String, ScoreVO> map = score.mapScore();
		Iterator<String> it = map.keySet().iterator();
		
		//print(ss.listScore());
		while(it.hasNext()) {
			String hak=it.next();
			ScoreVO vo=map.get(hak);
			
			System.out.print(hak+"\t");
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getKor()+"\t");
			System.out.print(vo.getEng()+"\t");
			System.out.print(vo.getMat()+"\t");
			System.out.print(vo.getTot()+"\t");
			System.out.print(vo.getAve()+"\t");
		}
		System.out.println();
	}
	
	public void findByHak() {
		System.out.println("\n학번 검색");
		
		System.out.print("검색할 학번?");
		String hak=sc.next();
		
		ScoreVO vo=score.readScore(hak);
		if(vo==null) {
			System.out.println("등록된 자료가 아닙니다.");
			return;
		}
		
		System.out.print(vo.getName()+"\t");
		System.out.print(vo.getKor()+"\t");
		System.out.print(vo.getEng()+"\t");
		System.out.print(vo.getMat()+"\t");
		System.out.print(vo.getTot()+"\t");
		System.out.print(vo.getAve()+"\t");
		System.out.println();
	}
	
	public void findByName() {
		System.out.println("\n이름 검색");
		
		System.out.print("검색할 이름?");
		String name=sc.next();
		
		List<ScoreVO> list=score.listScore(name);
		for(ScoreVO vo:list) {
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getKor()+"\t");
			System.out.print(vo.getEng()+"\t");
			System.out.print(vo.getMat()+"\t");
			System.out.print(vo.getTot()+"\t");
			System.out.print(vo.getAve()+"\t");	
		}
		System.out.println();
		
	}
	
	private void print(List<ScoreVO> list) {
		for(ScoreVO vo:list) {
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getKor()+"\t");
			System.out.print(vo.getEng()+"\t");
			System.out.print(vo.getMat()+"\t");
			System.out.print(vo.getTot()+"\t");
			System.out.print(vo.getAve()+"\t");
		}
	}
	
	
}
