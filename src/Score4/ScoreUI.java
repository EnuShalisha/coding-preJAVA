package score4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScoreUI {
	private Scanner sc=new Scanner(System.in);
	private Score ss = new ScoreImpl();
	
	public void menu() {
		int ch;
		while(true) {
			try {
				do {
					System.out.println("1.입력 2.수정 3.삭제 4.리스트");
					System.out.println("5.평점 6.이름검색 7.학번검색 8.종료");
					System.out.print("선택 => ");
					ch=sc.nextInt();
				} while(ch<1||ch>8);
				
				if(ch==8) {
					System.exit(0);
				}
				
				switch(ch) {
				case 1:input(); break;
				case 2:update(); break;
				case 3:delete(); break;
				case 4:printAll(); break;
				case 5:printGrade(); break;
				case 6:findByName(); break;
				case 7:findByHak(); break;
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
			}
		}
	}
	
	public void input() {
		System.out.println("\n자료 입력...");
		
		ScoreVO vo=new ScoreVO();
		try {
			System.out.print("학번?");
			vo.setHak(sc.next());
			
			if(ss.readScore(vo.getHak())!=null) {
				System.out.println("등록된 학번입니다.\n");
				return;
			}
			System.out.print("이름?");
			vo.setName(inputName()); 
			
			System.out.print("국어?");
			vo.setKor(inputScore());
			
			System.out.print("영어?");
			vo.setEng(inputScore());
			
			System.out.print("수학?");
			vo.setMat(inputScore());
			
			ss.append(vo);
			
			System.out.println("등록완료...");

		} catch (InputMismatchException e) {
			System.out.println("점수는 숫자만 가능합니다.");
		} catch (ScoreValidException e) {
			System.out.println(e.getMessage());
		} catch (KoreanValidException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}

	public void update() {
		System.out.println("\n자료 수정...");
		
		System.out.print("수정할 학번?");
		String hak=sc.next();
		
		ScoreVO vo=ss.readScore(hak);
		if(vo==null) {
			System.out.println("존재하지 않는 학번입니다.\n");
			return;
		}
		
		String name;
		int kor, eng, mat;
		
		try {
			System.out.print("이름?");
			name = inputName();
			
			System.out.print("국어?");
			kor = inputScore();
			
			System.out.print("영어?");
			eng = inputScore();

			System.out.print("수학?");
			mat = inputScore();

			vo.setName(name);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMat(mat);
			
			System.out.println("수정 완료...");
			
		} catch (InputMismatchException e) {
			System.out.println("점수는 숫자만 가능합니다.");
		} catch (ScoreValidException e) {
			System.out.println(e.getMessage());
		} catch (KoreanValidException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}
	
	public void delete() {
		System.out.println("\n자료 삭제...");
		
		String hak;
		System.out.print("삭제할 학번?");
		hak=sc.next();
		
		if(! ss.remove(hak)) {
			System.out.println("등록된 학번이 아닙니다.\n");
			return;
		}
		
		System.out.println("삭제완료...\n");
	}

	public void printAll() {
		System.out.println("\n전체 리스트...");
		
		ScoreVO[] list = ss.listScore();
		for(int i=0; i<ss.getCount(); i++) {
			ScoreVO vo = list[i];
			System.out.println(vo);
			// System.out.println(vo.toString());
		}
		System.out.println();
		
	}
	
	public void printGrade() {
		System.out.println("\n평점 출력...");
		
		ScoreVO[] list = ss.listScore();
		for(int i=0; i<ss.getCount(); i++) {
			ScoreVO vo=list[i];
			System.out.print(vo.getHak()+"\t");
			System.out.print(vo.getName()+"\t");
			System.out.print(ss.grade(vo.getKor())+"\t");
			System.out.print(ss.grade(vo.getEng())+"\t");
			System.out.print(ss.grade(vo.getMat())+"\n");
		}
		System.out.println();
	}
	
	public void findByName() {
		System.out.println("\n이름 검색...");
		
		String name;
		System.out.print("검색할 이름?");
		name=sc.next();
		
		ScoreVO[] list = ss.listScore();
		for(int i=0; i<ss.getCount(); i++) {
			ScoreVO vo=list[i];
			// if(vo.getName().startsWith(name)) {
			if(vo.getName().indexOf(name)>=0) {
				System.out.println(vo);
			}
		}
		System.out.println();
	}
	
	public void findByHak() {
		System.out.println("\n학번 검색...");
		
		String hak;
		System.out.print("검색할 학번?");
		hak=sc.next();
		
		ScoreVO vo=ss.readScore(hak);
		if(vo==null) {
			System.out.println("등록된 학번이 아닙니다.\n");
			return;
		}
		
		System.out.println(vo+"\n");
	}
	
	private String inputName() throws KoreanValidException {
		String s=null;
		String regex="^[가-힣]+$";
		s=sc.next();
		
		if(! s.matches(regex)) {
			throw new KoreanValidException("이름은 한글만 가능합니다.");
		}
		
		return s;
	}
	
	private int inputScore() throws ScoreValidException {
		int s=0;
		
		try {
			s=sc.nextInt();
			if(s<0 || s>100)
				throw new ScoreValidException("점수는 0~100 사이만 가능합니다.");
		} catch (InputMismatchException e) {
			sc.next();
			throw e;
		}
		
		return s;
	}
}
