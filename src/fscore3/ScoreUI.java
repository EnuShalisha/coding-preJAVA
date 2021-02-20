package fscore3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoreUI {
	private BufferedReader br=new BufferedReader(
			new InputStreamReader(System.in));
	private Score score=new ScoreImpl();
	
	public void menu() {
		int ch;
		
		while(true) {
			try {
				do {
					System.out.print("1.占쏙옙占� 2.占쏙옙占쏙옙 3.占쏙옙占쏙옙 4.占쏙옙占쏙옙트 5.占싻뱄옙占싯삼옙 6. 총점내림차순 7.占쏙옙占쏙옙 =>");
					ch=Integer.parseInt(br.readLine());
				} while(ch<1||ch>7);
				
				if(ch==7) {
					score.saveFile(); // 占쏙옙占싹울옙 占쏙옙占쏙옙
					return;
				}
				
				switch(ch) {
				case 1:insert(); break;
				case 2:update(); break;
				case 3:delete(); break;
				case 4:list(); break;
				case 5:findByHak(); break;
				case 6:sortTotDesc(); break;
				}
			} catch (NumberFormatException e) {
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void insert() {
		System.out.println("\n[占쏙옙占�]...");
		
		ScoreVO vo=new ScoreVO();
		try {
			System.out.print("占싻뱄옙?");
			vo.setHak(br.readLine());
			System.out.print("占싱몌옙?");
			vo.setName(br.readLine());
			System.out.print("占쏙옙占쏙옙?");
			vo.setKor(Integer.parseInt(br.readLine()));
			System.out.print("占쏙옙占쏙옙?");
			vo.setEng(Integer.parseInt(br.readLine()));
			System.out.print("占쏙옙占쏙옙?");
			vo.setMat(Integer.parseInt(br.readLine()));
			
			score.insertScore(vo);
			System.out.println("占쏙옙占쏙옙占쏙옙 占쌩곤옙 占싹뤄옙...\n");
			
		} catch (NumberFormatException e) {
			System.out.println("占쏙옙占쏙옙占쏙옙 占쏙옙占쌘몌옙 占쏙옙占쏙옙...\n");
		} catch (DuplicationException e) {
			System.out.println(e.getMessage()+"\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		System.out.println("\n[占쏙옙占쏙옙]...");
		String hak;
		
		try {
			System.out.println("占싻뱄옙 占쌉뤄옙");
			hak=br.readLine();
			ScoreVO vo=score.readScore(hak);
			if(vo==null){
				System.out.println("占쏙옙占쏙옙占쏙옙占쏙옙 占십댐옙 占싻뱄옙");
				return;
			}
			ScoreVO votm=vo;
			System.out.print("占싱몌옙?");
			votm.setName(br.readLine());
			System.out.print("占쏙옙占쏙옙?");
			votm.setKor(Integer.parseInt(br.readLine()));
			System.out.print("占쏙옙占쏙옙?");
			votm.setEng(Integer.parseInt(br.readLine()));
			System.out.print("占쏙옙占쏙옙?");
			votm.setMat(Integer.parseInt(br.readLine()));
			vo=votm;
			
			System.out.println("占쏙옙占쏙옙 占싹뤄옙");
			
		} catch (NumberFormatException e) {
			System.out.println("占쏙옙占쏙옙占쏙옙 占쏙옙占쌘몌옙 占쏙옙占쏙옙...\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void delete() {
		System.out.println("\n[占쏙옙占쏙옙]...");
		
		String hak;
		try {
			System.out.println("占싻뱄옙 占쌉뤄옙");
			hak=br.readLine();
			if(score.deleteScore(hak)){
				System.out.println("占쏙옙占쏙옙 占싹뤄옙");
			}
			else
				System.out.println("占쏙옙溝占쏙옙占� 占쏙옙占쏙옙 占싻뱄옙");
			
			System.out.println("占쏙옙占쏙옙 占싹뤄옙");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void list() {
		System.out.println("\n[占쏙옙占쏙옙트]...");
		
		sortHakAsc();
		for(ScoreVO vo:score.listScore()) {
			System.out.println(vo);
		}
		System.out.println();
		
	}
	
	public void findByHak() {
		System.out.println("\n[占싻뱄옙占싯삼옙]...");
		
		String hak;
		try {
			System.out.println("占싻뱄옙 占쌉뤄옙");
			hak=br.readLine();
			ScoreVO vo=score.readScore(hak);
			if(vo==null){
				System.out.println("占쏙옙占쏙옙占쏙옙占쏙옙 占십댐옙 占싻뱄옙");
				return;
			}
			
			/*System.out.println("占싻뱄옙: "+vo.getHak());
			System.out.println("占싱몌옙: "+vo.getName());
			System.out.println("占쏙옙占쏙옙: "+vo.getKor());
			System.out.println("占쏙옙占쏙옙: "+vo.getEng());
			System.out.println("占쏙옙占쏙옙: "+vo.getMat());
			System.out.println("占쏙옙占쏙옙: "+vo.getTot());
			System.out.println("占쏙옙占�: "+vo.getAve());*/
			System.out.println("占싻뱄옙\t占싱몌옙\t占쏙옙占쏙옙\t占쏙옙占쏙옙\t占쏙옙占쏙옙\t占쏙옙占쏙옙\t占쏙옙占�");
			System.out.println(vo+"\n");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void sortTotDesc() {
		System.out.println("총점 내림차순 나열");
		
		List<ScoreVO> list=score.listScore();
		
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				return -(o1.getTot()-o2.getTot());
			}
		};
		Collections.sort(list, comp);
		
		for(ScoreVO vo:list) {
			System.out.println(vo);
		}
		System.out.println();
	}
	
	public void sortHakAsc() {
		System.out.println("학번 오름차순 정리");
		
		List<ScoreVO> list=score.listScore();
		
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				return (o1.getHak().compareTo(o2.getHak()));
			}
		};
		Collections.sort(list, comp);
	}
	
}
