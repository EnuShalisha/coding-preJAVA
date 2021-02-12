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
					System.out.println("1.ÀÔ·Â 2.¼öÁ¤ 3.»èÁ¦ 4.¸®½ºÆ®");
					System.out.println("5.ÆòÁ¡ 6.ÀÌ¸§°Ë»ö 7.ÇÐ¹ø°Ë»ö 8.Á¾·á");
					System.out.print("¼±ÅÃ => ");
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
		System.out.println("\nÀÚ·á ÀÔ·Â...");
		
		ScoreVO vo=new ScoreVO();
		try {
			System.out.print("ÇÐ¹ø?");
			vo.setHak(sc.next());
			
			if(ss.readScore(vo.getHak())!=null) {
				System.out.println("µî·ÏµÈ ÇÐ¹øÀÔ´Ï´Ù.\n");
				return;
			}
			System.out.print("ÀÌ¸§?");
			vo.setName(inputName()); 
			
			System.out.print("±¹¾î?");
			vo.setKor(inputScore());
			
			System.out.print("¿µ¾î?");
			vo.setEng(inputScore());
			
			System.out.print("¼öÇÐ?");
			vo.setMat(inputScore());
			
			ss.append(vo);
			
			System.out.println("µî·Ï¿Ï·á...");

		} catch (InputMismatchException e) {
			System.out.println("Á¡¼ö´Â ¼ýÀÚ¸¸ °¡´ÉÇÕ´Ï´Ù.");
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
		System.out.println("\nÀÚ·á ¼öÁ¤...");
		
		System.out.print("¼öÁ¤ÇÒ ÇÐ¹ø?");
		String hak=sc.next();
		
		ScoreVO vo=ss.readScore(hak);
		if(vo==null) {
			System.out.println("Á¸ÀçÇÏÁö ¾Ê´Â ÇÐ¹øÀÔ´Ï´Ù.\n");
			return;
		}
		
		String name;
		int kor, eng, mat;
		
		try {
			System.out.print("ÀÌ¸§?");
			name = inputName();
			
			System.out.print("±¹¾î?");
			kor = inputScore();
			
			System.out.print("¿µ¾î?");
			eng = inputScore();

			System.out.print("¼öÇÐ?");
			mat = inputScore();

			vo.setName(name);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMat(mat);
			
			System.out.println("¼öÁ¤ ¿Ï·á...");
			
		} catch (InputMismatchException e) {
			System.out.println("Á¡¼ö´Â ¼ýÀÚ¸¸ °¡´ÉÇÕ´Ï´Ù.");
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
		System.out.println("\nÀÚ·á »èÁ¦...");
		
		String hak;
		System.out.print("»èÁ¦ÇÒ ÇÐ¹ø?");
		hak=sc.next();
		
		if(! ss.remove(hak)) {
			System.out.println("µî·ÏµÈ ÇÐ¹øÀÌ ¾Æ´Õ´Ï´Ù.\n");
			return;
		}
		
		System.out.println("»èÁ¦¿Ï·á...\n");
	}

	public void printAll() {
		System.out.println("\nÀüÃ¼ ¸®½ºÆ®...");
		
		ScoreVO[] list = ss.listScore();
		for(int i=0; i<ss.getCount(); i++) {
			ScoreVO vo = list[i];
			System.out.println(vo);
			// System.out.println(vo.toString());
		}
		System.out.println();
		
	}
	
	public void printGrade() {
		System.out.println("\nÆòÁ¡ Ãâ·Â...");
		
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
		System.out.println("\nÀÌ¸§ °Ë»ö...");
		
		String name;
		System.out.print("°Ë»öÇÒ ÀÌ¸§?");
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
		System.out.println("\nÇÐ¹ø °Ë»ö...");
		
		String hak;
		System.out.print("°Ë»öÇÒ ÇÐ¹ø?");
		hak=sc.next();
		
		ScoreVO vo=ss.readScore(hak);
		if(vo==null) {
			System.out.println("µî·ÏµÈ ÇÐ¹øÀÌ ¾Æ´Õ´Ï´Ù.\n");
			return;
		}
		
		System.out.println(vo+"\n");
	}
	
	private String inputName() throws KoreanValidException {
		String s=null;
		String regex="^[°¡-ÆR]+$";
		s=sc.next();
		
		if(! s.matches(regex)) {
			throw new KoreanValidException("ÀÌ¸§Àº ÇÑ±Û¸¸ °¡´ÉÇÕ´Ï´Ù.");
		}
		
		return s;
	}
	
	private int inputScore() throws ScoreValidException {
		int s=0;
		
		try {
			s=sc.nextInt();
			if(s<0 || s>100)
				throw new ScoreValidException("Á¡¼ö´Â 0~100 »çÀÌ¸¸ °¡´ÉÇÕ´Ï´Ù.");
		} catch (InputMismatchException e) {
			sc.next();
			throw e;
		}
		
		return s;
	}
}
