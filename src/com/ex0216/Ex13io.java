package com.ex0216;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Ex13io {
	
	public static void dirList(String pathname){
	File file=new File(pathname);
	File[] ff=file.listFiles();
	
	if(ff==null)
		return;
	
	List<DirectoryVO> list=new LinkedList<>();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
	String s;
	
	for(File f: ff) {
		s=sdf.format(new Date(f.lastModified()));
		DirectoryVO vo=new DirectoryVO();
		
		if(f.isFile()) {
			vo.setName(f.getName());
			vo.setModified(s);
			vo.setType(1);
			vo.setLength(f.length());
		}else if(f.isDirectory()) {
			vo.setName(f.getName());
			vo.setModified(s);
			vo.setType(0);
			list.add(vo);
		}
	}
	Comparator<DirectoryVO> comp = new Comparator<DirectoryVO>() {

		@Override
		public int compare(DirectoryVO o1, DirectoryVO o2) {
			if(o1.getType()>o2.getType())
				return 1;
			else if(o1.getType()<o2.getType())
				return -1;
			else
				return (int) (o1.getLength()-o2.getLength());
		}
	};
	Collections.sort(list, comp);
	
	/*Comparator<DirectoryVO> comp2 = new Comparator<DirectoryVO>() {

		@Override
		public int compare(DirectoryVO o1, DirectoryVO o2) {
			 return (int) (o1.getLength()-o2.getLength());
		}
		
	};
	
	Collections.sort(list, comp2);
	*/
	
	System.out.println("이름\t\t수정날짜\t\t유형\t\t크기");
	for(DirectoryVO vv:list) {
		System.out.print(vv.getName()+"\t\t");
		System.out.print(vv.getModified()+"\t\t");
		System.out.print(vv.getType()==0?"폴더":"파일"+"\t\t");
		if(vv.getType()==1) {
			System.out.print(vv.getLength()+"\t\t");	
		}
	System.out.println();
	}
	
	}
	public static void main(String[] args) {
		dirList("c:\\windows");

	}

}

class DirectoryVO{
	private String name;	 // 파일 또는 폴더명
	private String modified; // 수정일자
	private int type;		 // 0은 폴더, 1은 파일
	private long length;	 // 파일길이
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	
}