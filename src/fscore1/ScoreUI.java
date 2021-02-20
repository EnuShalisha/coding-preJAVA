package fscore1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ScoreUI {
	private BufferedReader br=new BufferedReader(
			new InputStreamReader(System.in));
	private Score score=new ScoreImpl();
	
	public void menu() {
		int ch;
		
		while(true) {
			try {
				do {
					System.out.print("1.등록 2.수정 3.삭제 4.리스트 5.학번검색 6.종료 =>");
					ch=Integer.parseInt(br.readLine());
				} while(ch<1||ch>6);
				
				if(ch==6) {
					score.saveFile(); // 파일에 저장
					return;
				}
				
				switch(ch) {
				case 1:insert(); break;
				case 2:update(); break;
				case 3:delete(); break;
				case 4:list(); break;
				case 5:findByHak(); break;
				}
			} catch (NumberFormatException e) {
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void insert() {
		System.out.println("\n[등록]...");
		
		ScoreVO vo=new ScoreVO();
		try {
			System.out.print("학번?");
			vo.setHak(br.readLine());
			System.out.print("이름?");
			vo.setName(br.readLine());
			System.out.print("국어?");
			vo.setKor(Integer.parseInt(br.readLine()));
			System.out.print("영어?");
			vo.setEng(Integer.parseInt(br.readLine()));
			System.out.print("수학?");
			vo.setMat(Integer.parseInt(br.readLine()));
			
			score.insertScore(vo);
			System.out.println("데이터 추가 완료...\n");
			
		} catch (NumberFormatException e) {
			System.out.println("점수는 숫자만 가능...\n");
		} catch (DuplicationException e) {
			System.out.println(e.getMessage()+"\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		System.out.println("\n[수정]...");
		String hak;
		
		try {
			System.out.println("학번 입력");
			hak=br.readLine();
			ScoreVO vo=score.readScore(hak);
			if(vo==null){
				System.out.println("존재하지 않는 학번");
				return;
			}
			ScoreVO votm=vo;
			System.out.print("이름?");
			votm.setName(br.readLine());
			System.out.print("국어?");
			votm.setKor(Integer.parseInt(br.readLine()));
			System.out.print("영어?");
			votm.setEng(Integer.parseInt(br.readLine()));
			System.out.print("수학?");
			votm.setMat(Integer.parseInt(br.readLine()));
			vo=votm;
			
			System.out.println("수정 완료");
			
		} catch (NumberFormatException e) {
			System.out.println("점수는 숫자만 가능...\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void delete() {
		System.out.println("\n[삭제]...");
		
		String hak;
		try {
			System.out.println("학번 입력");
			hak=br.readLine();
			if(score.deleteScore(hak)){
				System.out.println("삭제 완료");
			}
			else
				System.out.println("등록되지 않은 학번");
			
			System.out.println("삭제 완료");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void list() {
		System.out.println("\n[리스트]...");
		
		for(ScoreVO vo:score.listScore()) {
			System.out.println(vo);
		}
		System.out.println();
		
	}
	
	public void findByHak() {
		System.out.println("\n[학번검색]...");
		
		String hak;
		try {
			System.out.println("학번 입력");
			hak=br.readLine();
			ScoreVO vo=score.readScore(hak);
			if(vo==null){
				System.out.println("존재하지 않는 학번");
				return;
			}
			
			/*System.out.println("학번: "+vo.getHak());
			System.out.println("이름: "+vo.getName());
			System.out.println("국어: "+vo.getKor());
			System.out.println("영어: "+vo.getEng());
			System.out.println("수학: "+vo.getMat());
			System.out.println("총점: "+vo.getTot());
			System.out.println("평균: "+vo.getAve());*/
			System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
			System.out.println(vo+"\n");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
