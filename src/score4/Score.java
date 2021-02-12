package score4;

public interface Score {
	public int getCount();
	public ScoreVO[] listScore();
	public int append(ScoreVO vo);
	public double grade(int score);
	public ScoreVO readScore(String hak);
	public int indexOf(String hak);
	public boolean remove(String hak);
}
