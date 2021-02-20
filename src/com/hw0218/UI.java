package com.hw0218;

public class UI {

	public static void main(String[] args) {
		Score u=new Score();
		u.loadFile();
		u.totDesc();
		u.saveFile();
		u.showFile();
	}

}