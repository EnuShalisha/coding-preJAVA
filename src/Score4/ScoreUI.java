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
					System.out.println("1.�Է� 2.���� 3.���� 4.����Ʈ");
					System.out.println("5.���� 6.�̸��˻� 7.�й��˻� 8.����");
					System.out.print("���� => ");
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
		System.out.println("\n�ڷ� �Է�...");
		
		ScoreVO vo=new ScoreVO();
		try {
			System.out.print("�й�?");
			vo.setHak(sc.next());
			
			if(ss.readScore(vo.getHak())!=null) {
				System.out.println("��ϵ� �й��Դϴ�.\n");
				return;
			}
			System.out.print("�̸�?");
			vo.setName(inputName()); 
			
			System.out.print("����?");
			vo.setKor(inputScore());
			
			System.out.print("����?");
			vo.setEng(inputScore());
			
			System.out.print("����?");
			vo.setMat(inputScore());
			
			ss.append(vo);
			
			System.out.println("��ϿϷ�...");

		} catch (InputMismatchException e) {
			System.out.println("������ ���ڸ� �����մϴ�.");
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
		System.out.println("\n�ڷ� ����...");
		
		System.out.print("������ �й�?");
		String hak=sc.next();
		
		ScoreVO vo=ss.readScore(hak);
		if(vo==null) {
			System.out.println("�������� �ʴ� �й��Դϴ�.\n");
			return;
		}
		
		String name;
		int kor, eng, mat;
		
		try {
			System.out.print("�̸�?");
			name = inputName();
			
			System.out.print("����?");
			kor = inputScore();
			
			System.out.print("����?");
			eng = inputScore();

			System.out.print("����?");
			mat = inputScore();

			vo.setName(name);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMat(mat);
			
			System.out.println("���� �Ϸ�...");
			
		} catch (InputMismatchException e) {
			System.out.println("������ ���ڸ� �����մϴ�.");
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
		System.out.println("\n�ڷ� ����...");
		
		String hak;
		System.out.print("������ �й�?");
		hak=sc.next();
		
		if(! ss.remove(hak)) {
			System.out.println("��ϵ� �й��� �ƴմϴ�.\n");
			return;
		}
		
		System.out.println("�����Ϸ�...\n");
	}

	public void printAll() {
		System.out.println("\n��ü ����Ʈ...");
		
		ScoreVO[] list = ss.listScore();
		for(int i=0; i<ss.getCount(); i++) {
			ScoreVO vo = list[i];
			System.out.println(vo);
			// System.out.println(vo.toString());
		}
		System.out.println();
		
	}
	
	public void printGrade() {
		System.out.println("\n���� ���...");
		
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
		System.out.println("\n�̸� �˻�...");
		
		String name;
		System.out.print("�˻��� �̸�?");
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
		System.out.println("\n�й� �˻�...");
		
		String hak;
		System.out.print("�˻��� �й�?");
		hak=sc.next();
		
		ScoreVO vo=ss.readScore(hak);
		if(vo==null) {
			System.out.println("��ϵ� �й��� �ƴմϴ�.\n");
			return;
		}
		
		System.out.println(vo+"\n");
	}
	
	private String inputName() throws KoreanValidException {
		String s=null;
		String regex="^[��-�R]+$";
		s=sc.next();
		
		if(! s.matches(regex)) {
			throw new KoreanValidException("�̸��� �ѱ۸� �����մϴ�.");
		}
		
		return s;
	}
	
	private int inputScore() throws ScoreValidException {
		int s=0;
		
		try {
			s=sc.nextInt();
			if(s<0 || s>100)
				throw new ScoreValidException("������ 0~100 ���̸� �����մϴ�.");
		} catch (InputMismatchException e) {
			sc.next();
			throw e;
		}
		
		return s;
	}
}
