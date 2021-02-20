package com.ex0216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex01 {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("서울");
		list.add("부산");
		list.add("대구");
		list.add("광주");
		list.add("광주");
		list.add("인천");
		list.add("대전");
		list.add("울산");
		list.add("세종");
		//정렬(객체 생성 필요 없음)
		Collections.sort(list);
		System.out.println(list);
		
		//2분검색(정렬시 사용 가능)
		int idx = Collections.binarySearch(list, "서울");
		if(idx>=0) {
			System.out.println("서울은 "+idx+" 인덱스에 위치");
			System.out.println(list.get(idx));
		}
		
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		//역순 정렬이라기엔 너무 검색이 잘되는데
		idx=Collections.binarySearch(list, "부산");
		System.out.println("부산위치: "+idx);
		
		idx=Collections.binarySearch(list, "부산", Collections.reverseOrder());
		System.out.println("부산위치: "+idx);
		
		//셔플
		Collections.shuffle(list);
		System.out.println(list);
		
		//배열로 - Integer는 클래스라서 되고, int는 기본 자료형이라 안됨
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Collections.shuffle(Arrays.asList(arr)); // 배열을 어레이리스트로는 한번 더 거쳐줘야함
		String s=Arrays.toString(arr);
		System.out.println(s);
	}

}
