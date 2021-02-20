package com.ex0218;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Iterator;

public class Ex02 {
//ObjectInput / OutputStream
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 객체 저장 - 객체 필드값 저장
		// hashtable suburb가 바로 properties
		Hashtable<String, String> map = new Hashtable<String, String>();
		map.put("자바", "프로그래밍");
		map.put("HTML", "웹프로그래밍");
		map.put("오라클", "데이터베이스");
		
		String pathname="object.txt";
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(pathname))) {
			//객체를 저장하면 파일 선두에 클래스명을 저장하고
			//다음으로 필드의 내용이 저장됨
			
			oos.writeObject(map);
			System.out.println("저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(pathname))) {
			@SuppressWarnings("unchecked")
			Hashtable<String, String> ht=(Hashtable<String, String>)ois.readObject();
			
			Iterator<String> it=ht.keySet().iterator();
			while(it.hasNext()) {
				String key=it.next();
				String value=ht.get(key);
				System.out.println(key+"->"+value);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
