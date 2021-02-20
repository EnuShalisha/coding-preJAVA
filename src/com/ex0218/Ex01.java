package com.ex0218;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex01 {
//기본자료형으로 입력과 출력: DataInput-OutputStream
	public static void main(String[] args) {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"))) {
			//유의사항 1. 저장한 순서를 반드시 지켜 불러와야함
			//2. datainput으로밖엔 못불러옴
			dos.writeUTF("seoul");
			dos.writeByte(65);//65에 해당하는 문자
			dos.writeInt(356);
			dos.writeUTF("java");
			dos.writeChar('X');
			
			System.out.println("파일 저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		System.out.println("-------");
		try(DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"))) {
			String s=dis.readUTF();
			byte b=dis.readByte();
			int n=dis.readInt();
			String sn=dis.readUTF();
			char c=dis.readChar();
			System.out.println(s+b+n+sn+c);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
