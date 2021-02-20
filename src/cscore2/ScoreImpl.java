package cscore2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ScoreImpl implements Score {
	//hashMap: 키 등록 순서 유지 x
	//LinkedHashMap: 키 등록 순서 유지
	private Map<String, ScoreVO>map = new LinkedHashMap<>();
	
	
	@Override
	public boolean insertScore(String hak, ScoreVO vo) {
		if(map.containsKey(hak))
			return false;
		
		map.put(hak, vo);
		return true;
	}

	@Override
	public boolean deleteScore(String hak) {
		//진짜 개쉽네
		ScoreVO vo=map.remove(hak);
		return vo!=null;
	}

	@Override
	public Map<String, ScoreVO> mapScore() {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public ScoreVO readScore(String hak) {
		
		return map.get(hak);
	}

	@Override
	public List<ScoreVO> listScore(String name) {
		List<ScoreVO> list=new ArrayList<ScoreVO>();
		Iterator<String> it=map.keySet().iterator();
		while(it.hasNext()) {
			String hak=it.next();
			ScoreVO vo=map.get(hak);
			if(vo.getName().startsWith(name)) {
				list.add(vo);
			}
		}
		return null;
	}
	
}
