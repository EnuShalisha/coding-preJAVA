package Score4;

import java.util.ArrayList;
import java.util.List;

import score2.ScoreVO;

public class ScoreImpl {
	private List<ScoreVO> list=new ArrayList<>();
	
	public ScoreVO readScore(String hak) {
		ScoreVO vo=null;
		for(ScoreVO vv: list) {
			if(vv.getHak().equals(hak)) {
				vo=vv;
				break;
			}
		}
		return vo;
	}
	
	public boolean insertScore(ScoreVO vo) {
		if(readScore(vo.getHak())!=null)
			return false;
		list.add(vo);
		return true;
	}
	
	public boolean deleteScore(String hak) {
		ScoreVO vo = readScore(hak);
		if(vo==null)
			return false;
		list.remove(vo);
		return true;
	}
}

