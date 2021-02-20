package fscore2;

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
					System.out.print("1.��� 2.���� 3.���� 4.����Ʈ 5.�й��˻� 6.���� =>");
					ch=Integer.parseInt(br.readLine());
				} while(ch<1||ch>6);
				
				if(ch==6) {
					score.saveFile(); // ���Ͽ� ����
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
		System.out.println("\n[���]...");
		
		ScoreVO vo=new ScoreVO();
		try {
			System.out.print("�й�?");
			vo.setHak(br.readLine());
			System.out.print("�̸�?");
			vo.setName(br.readLine());
			System.out.print("����?");
			vo.setKor(Integer.parseInt(br.readLine()));
			System.out.print("����?");
			vo.setEng(Integer.parseInt(br.readLine()));
			System.out.print("����?");
			vo.setMat(Integer.parseInt(br.readLine()));
			
			score.insertScore(vo);
			System.out.println("������ �߰� �Ϸ�...\n");
			
		} catch (NumberFormatException e) {
			System.out.println("������ ���ڸ� ����...\n");
		} catch (DuplicationException e) {
			System.out.println(e.getMessage()+"\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		System.out.println("\n[����]...");
		String hak;
		
		try {
			System.out.println("�й� �Է�");
			hak=br.readLine();
			ScoreVO vo=score.readScore(hak);
			if(vo==null){
				System.out.println("�������� �ʴ� �й�");
				return;
			}
			ScoreVO votm=vo;
			System.out.print("�̸�?");
			votm.setName(br.readLine());
			System.out.print("����?");
			votm.setKor(Integer.parseInt(br.readLine()));
			System.out.print("����?");
			votm.setEng(Integer.parseInt(br.readLine()));
			System.out.print("����?");
			votm.setMat(Integer.parseInt(br.readLine()));
			vo=votm;
			
			System.out.println("���� �Ϸ�");
			
		} catch (NumberFormatException e) {
			System.out.println("������ ���ڸ� ����...\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void delete() {
		System.out.println("\n[����]...");
		
		String hak;
		try {
			System.out.println("�й� �Է�");
			hak=br.readLine();
			if(score.deleteScore(hak)){
				System.out.println("���� �Ϸ�");
			}
			else
				System.out.println("��ϵ��� ���� �й�");
			
			System.out.println("���� �Ϸ�");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void list() {
		System.out.println("\n[����Ʈ]...");
		
		for(ScoreVO vo:score.listScore()) {
			System.out.println(vo);
		}
		System.out.println();
		
	}
	
	public void findByHak() {
		System.out.println("\n[�й��˻�]...");
		
		String hak;
		try {
			System.out.println("�й� �Է�");
			hak=br.readLine();
			ScoreVO vo=score.readScore(hak);
			if(vo==null){
				System.out.println("�������� �ʴ� �й�");
				return;
			}
			
			/*System.out.println("�й�: "+vo.getHak());
			System.out.println("�̸�: "+vo.getName());
			System.out.println("����: "+vo.getKor());
			System.out.println("����: "+vo.getEng());
			System.out.println("����: "+vo.getMat());
			System.out.println("����: "+vo.getTot());
			System.out.println("���: "+vo.getAve());*/
			System.out.println("�й�\t�̸�\t����\t����\t����\t����\t���");
			System.out.println(vo+"\n");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
