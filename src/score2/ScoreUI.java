package score2;

import java.util.Scanner;

public class ScoreUI {
	private Scanner sc = new Scanner(System.in);
	private Score ss = new Score();
	
	public void menu() {
		int ch;
		
		while(true) {
			do {
				System.out.print("1. 등록 2. 수정 3. 검색 4. 리스트 5. 삭제 6. 종료 => ");
				ch=sc.nextInt();
			}while(ch<1||ch>6);
			
			if(ch==6) return;
			
			switch(ch) { // 여기 스위치에 해당되는 메소드들은 일단 ui에 위치
			case 1:input(); break;
			case 2:update(); break;
			case 3:findByHak(); break;
			case 4:list(); break;
			case 5:remove(); break;
			}
		}
	}
	public void input() {
		System.out.println("\n데이터 입력..");
		
		ScoreVO vo = new ScoreVO();
		System.out.print("학번? ");
		vo.setHak(sc.next());
		
		System.out.print("이름?");
		vo.setName(sc.next());
		
		System.out.print("국어?");
		vo.setKor(sc.nextInt());
		
		System.out.print("영어?");
		vo.setEng(sc.nextInt());
		
		System.out.print("수학?");
		vo.setMat(sc.nextInt());
		
		//ss.append(vo);  배열에 객체 저장
		int n=ss.append(vo);
		if(n==-1) // 질문 1(s). 왜 디버깅을하면 여기서 ss.append로 넘어가는가?
	//위와 같음 - 배열에 저장하고 시작함
			System.out.println("인원 초과로 추가 불가");
		else System.out.println("데이터 등록 완료");
	}
	
	
	public void list() {
		System.out.println("\n데이터 리스트..");
		
		ScoreVO[] vv = ss.listScore(); // vv[] = returned list= (private) Scorevo[]
		System.out.println("등록된 인원수 : "+ss.getCount());
		for(int i=0; i<ss.getCount(); i++) {
			ScoreVO vo = vv[i];
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
	
	
	public void findByHak() {
		System.out.println("\n학번 검색..");
		
		String hak;
		System.out.print("검색할 학번? ");
		hak=sc.next(); // hak 변수로 저장
		ScoreVO vo= ss.readScore(hak); // 그리고 hak을 파라미터로 넣은 vo 인스턴스로 넘어감
		
		if(vo==null) {
			System.out.println("등록된 정보가 없음");
			return;
		}
		System.out.print(vo.getHak()+"\t");
		System.out.print(vo.getName()+"\t");
		System.out.print(vo.getKor()+"\t");
		System.out.print(vo.getEng()+"\t");
		System.out.print(vo.getMat()+"\t");
		System.out.print(vo.getTot()+"\t");
		System.out.print(vo.getAve()+"\n");	
	}
	
	
	public void update() {
		System.out.println("\n데이터 수정..");
		
		String hak;
		System.out.print("수정할 학번? ");
		hak=sc.next();
		ScoreVO vo = ss.readScore(hak);
		
		if(vo==null) {
			System.out.println("등록된 정보가 없음\n");
			return;
		}
		
		System.out.print("학번? ");
		vo.setHak(sc.next());
		
		System.out.print("이름?");
		vo.setName(sc.next());
		
		System.out.print("국어?");
		vo.setKor(sc.nextInt());
		
		System.out.print("영어?");
		vo.setEng(sc.nextInt());
		
		System.out.print("수학?");
		vo.setMat(sc.nextInt());
		
		System.out.println("데이터 수정 완료");
		
	}
	
	public void remove() {
		System.out.println("\n데이터 삭제..");
		
		String hak;
		System.out.print("수정할 학번? ");
		hak=sc.next();
		
		if(ss.remove(hak)==false) {
			System.out.println("등록된 정보가 없음\n");
			return;
		}
		
		System.out.println("데이터 삭제 완료");
		
	}
	
}
