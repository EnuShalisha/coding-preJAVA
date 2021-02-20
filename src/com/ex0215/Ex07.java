package com.ex0215;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex07 {

	public static void main(String[] args) {
		Map<String, Integer> map =new HashMap<>();
		//Map<키, 값>: 키는 중복허용 안함
		//HashMap: 	입력 순서 유지 x
		//			동기화 지원 x
		//put: map에 데이터 등록(cf. add)
		map.put("서울", 1000);
		map.put("부산", 350);
		map.put("대구", 250);
		map.put("인천", 300);
		map.put("광주", 150);
		map.put("대전", 150);
		map.put("서울", 980); // 키가 같으면 덮어쓰기
		
		System.out.println(map);
		
		//map 데이터 가져오기
		System.out.println(map.get("서울"));//키를 입력했더니 값이 출력
		
		//키 존재여부
		System.out.println(map.containsKey("서울"));
		
		//Map은 Iterator가 없음(=향상된 for문 사용 x)
		//키는 set이므로 set으로 불러와서 반복자, 처음부터 끝까지 순회
		Set<String> key = map.keySet(); // keyset
		Iterator<String> it=key.iterator();
		while(it.hasNext()) {
			String s=it.next();
			Integer v=map.get(s);
			System.out.println(s+"->"+v);
		}
		
		//서울 지우기
		System.out.println(map.remove("서울"));
		System.out.println(map);
	}

}
