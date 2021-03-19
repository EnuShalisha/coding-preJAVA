package com.ex0223;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Ex01 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String site, s;
		try {
			System.out.print("웹사이트 주소[https://wwww.naver.com] ?");
			site=br.readLine();
			
			URL url = new URL(site);
			InputStream is = url.openStream();
			BufferedReader br2 = new BufferedReader(
					new InputStreamReader(is, "UTF-8"));
			
			while((s=br2.readLine())!=null) {
				System.out.println(s);
			}
			br2.close();
		} catch (Exception e) {
			// TODO: handle exception
		} 

	}

}
