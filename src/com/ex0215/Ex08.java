package com.ex0215;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex08 {

	public static void main(String[] args) {
		//hashmap: 동기화 지원안함
		//hashtable: 동기화 지원
		Map<String, Integer> map = new Hashtable<>();
		map.put("서울", 1000);
		map.put("부산", 350);
		map.put("인천", 300);
		
		Iterator<String> it=map.keySet().iterator();
		while(it.hasNext()) {
			String key=it.next();
			Integer value=map.get(key);
			System.out.println(key+" : "+value);
		}
		
		//map.entry: 키 값의 한쌍
		Set<Map.Entry<String, Integer>> set=map.entrySet();
		Iterator<Map.Entry<String, Integer>> it2=set.iterator();
		while(it2.hasNext()) {
			Map.Entry<String, Integer> e=it2.next();
			String key=e.getKey();
			Integer value=e.getValue();
			System.out.println(key+"->"+value);
		}
		
		//map의 value를 list로
		List<Integer> list=new LinkedList<Integer>(map.values());
		System.out.println(list);

	}

}
