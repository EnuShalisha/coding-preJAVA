package com.ex0202;

public class Ex01 {

	public static void main(String[] args) {
		String s = "seoul korea";
		
		System.out.println(s);
		
		System.out.println("길이: "+s.length());
		
		//인덱싱, 첫 글자 시작위치는 내가 알아야함
		System.out.println(s.substring(6, 9)); // 첫 인덱스, 끝위치+1
		System.out.println(s.substring(6)); // korea
		
		char c = s.charAt(6);
		System.out.println(c); // k
		
		System.out.println(s.equals("seoul korea")); // true
		System.out.println(s.equals("Seoul Korea")); // false
		System.out.println(s.equalsIgnoreCase("Seoul Korea")); // 대소문자 무시
		
		System.out.println(s.startsWith("seoul")); // true / false
		System.out.println(s.endsWith("korea"));
		
		System.out.println(s.indexOf("xy")); // 없으면 -1
		System.out.println(s.indexOf("o")); // 2
		System.out.println(s.lastIndexOf("o")); // 7
		System.out.println(s.indexOf("o", 5)); // 7(5인덱스부터 검색)
		
		s="abc.png";
		String xt = s.substring(s.lastIndexOf(".")+1);
		System.out.println("확장자: "+xt);
		
		s="seoul"; // 대문자 변환
		s=s.toUpperCase();
		System.out.println(s);
		
		s="우리나라 대한민국 대한사람"; // 단어 변환
		s=s.replace("대한", "大韓"); // 정규식-영문자, 특수문자, 한글 단위 등- 사용 불가
		System.out.println(s);
		
		s="우리나라 대한민국 대한사람";
		s=s.replaceAll("대한", "大韓");
		System.out.println(s);
		
		s="우리 12 나라 88 대한 724";
		s=s.replaceAll("\\d", ""); // '\'를 치고싶으면 \\ 이렇게 두번
		System.out.println(s);
		
		s="우리 12 나라 88AB 대한 cd724"; // 영숫자 없애기
		s=s.replaceAll("\\w", "");
		System.out.println(s);
		
		s="우리 12 나라 88AB 대한 cd724"; // 한글과 공백 없애기
		s=s.replaceAll("[가-힣]|\\s", ""); // 이게 한글 글자의 바운더리 또는 공백
		System.out.println(s);
		
		s="    자    바    ";
		System.out.println(":"+s+":");
		System.out.println(":"+s.trim()+":");
		System.out.println(":"+s.replaceAll(" ", "")+":");
		System.out.println(":"+s.replaceAll("\\s", "")+":");
		//\\s는 공백 탭 엔터 다포함
		
		
	}

}
