package fscore1;

import java.util.List;

public interface Score {
	public void insertScore(ScoreVO vo) throws DuplicationException;
	public boolean deleteScore(String hak);
	public List<ScoreVO> listScore();
	public ScoreVO readScore(String hak);
	public void saveFile();
}
