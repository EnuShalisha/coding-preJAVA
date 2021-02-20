package cscore2;

import java.util.List;
import java.util.Map;

public interface Score {
	public boolean insertScore(String hak, ScoreVO vo);
	public boolean deleteScore(String hak);
	public Map<String, ScoreVO> mapScore();
	public ScoreVO readScore(String hak);
	public List<ScoreVO> listScore(String name);
}
