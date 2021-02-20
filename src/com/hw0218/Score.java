package com.hw0218;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Score {
	private String pathname="user.txt";
	private String destname="pass.txt";
	private List<ScoreVO> list=new ArrayList<>();
	
	public void loadFile() {
		File f=new File(pathname);
		
		if(! f.exists()) { 
			return;
		}
		
		try(BufferedReader br=new BufferedReader(new FileReader(f))) {
			String s;
			while((s=br.readLine())!=null) {
				String[]ss=s.split(",");
				if(ss.length!=4)
					continue;
				
				ScoreVO vo=new ScoreVO();
				vo.setName(ss[0]);
				vo.setKor(Integer.parseInt(ss[1]));
				vo.setEng(Integer.parseInt(ss[2]));
				vo.setMat(Integer.parseInt(ss[3]));
				
				list.add(vo);
			}
		} //파일낫파운드, io
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveFile() {
		File f=new File(destname);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			
			for(ScoreVO vo:list) {
			try {
				int a=vo.getKor(); int b=vo.getEng(); int c=vo.getMat();
				if(a<40||b<40||c<40)
					throw new FallshortException("점수 미달");
				if((a+b+c)/3<60)
					throw new UnpassException("불합격");
				oos.writeObject(vo);
			}
			catch (Exception e) {
				
			}
			}
			System.out.println("합격자 명단을 생성했습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void totDesc() {
		System.out.println("총점 내림차순 정리");
		
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				return -(o1.getTot()-o2.getTot());
			}
		};
		Collections.sort(list, comp);
	}
	
	public void showFile() {
		ScoreVO vo=null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(destname)))
		{while(true) {
			vo=(ScoreVO) ois.readObject();
			System.out.print(vo.getName()+", ");
			System.out.print(vo.getKor()+", ");
			System.out.print(vo.getEng()+", ");
			System.out.println(vo.getMat());
		}
			
		} catch (EOFException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}

	}
}
