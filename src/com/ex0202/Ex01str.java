package com.ex0202;

public class Ex01str {

	public static void main(String[] args) {
		//StringBuffer: 동기화 지원. 멀티스레드 환경에서 안전
		//StringBuilder: 동기화 지원 인함. StringBuffer보다 빠름.
		//StringBuffer, StringBuilder는 가변적인 문자열을 처리할 때
		//String보다 유용
		
		String s="ab";
		s+="cd"; //문제의 소지가 많은 코딩
		
		//다음의 연산은 속도가 빠름
		s="ab"+"cd"+"xy"; // 이게 내부적으로 StringBuilder를 사용한 예시
		
		
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer("korea");
		
		sb1.append("korea");
		
		System.out.println(sb1);
		System.out.println(sb2);
		
		System.out.println(sb1==sb2); // 주소비교
		System.out.println(sb1.equals(sb2));
			// String의 equals는 문자열값 비교
			// StringBuffer의 equals는 주소 비교
			// StringBuffer로 최후의 값 연산은 안되고, 문자열 변환이 필요함
		
		//값 변환 방법 - 	string간의 비교
		System.out.println(sb1.toString().equals(sb2.toString()));
		
		
		System.out.println(sb1.length()); //이건 가능
		
		StringBuffer sb3=new StringBuffer();
		System.out.println("초기버퍼크기: "+sb3.capacity());
		sb3.append("java");
		sb3.append("oracle");
		sb3.append("servlet");
		System.out.println("세개 append 후 버퍼크기: "+sb3.capacity());
		sb3.insert(0, "개발자");
		System.out.println(sb3);
		
		//사이에 문자 집어넣기
		System.out.println(sb3.indexOf("oracle"));
		//sb3.insert(7, "html5");// 인덱스 앞으로 놓음
		sb3.insert(sb3.indexOf("oracle")+"oracle".length(), "html5");
		System.out.println(sb3);
		sb3.delete(sb3.indexOf("html5"), sb3.indexOf("html5")+"html5".length());
		
		//string으로 변환 후 string 메소드 사용 가능
		System.out.println(sb3.toString().toUpperCase());
		
		//모두 지우기
		sb3.delete(0, sb3.length());
		System.out.println("버퍼:"+sb3.capacity()); // 버퍼는 줄어들지 않음
		
	}

}
