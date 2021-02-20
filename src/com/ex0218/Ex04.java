package com.ex0218;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ex04 {

	public static void main(String[] args) {
		String pathname="object2.txt";
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathname))){
			while(true) {
				User u= (User)ois.readObject();
				System.out.print(u.getName()+"\t");
				System.out.print(u.getAge()+"\t");
				System.out.println(u.getTel());
			}
		}catch (EOFException e) {
			// TODO: handle exception
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
