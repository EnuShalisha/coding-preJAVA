package score4;

import java.text.ChoiceFormat;

public class ScoreImpl implements Score {
	private ScoreVO[] list;
	private int count;
	
	public ScoreImpl() {
		allocation(10); // 초기에 10개의 배열선언
	}
	
	private void allocation(int capacity) {
		ScoreVO[] temp = new ScoreVO[capacity];
		if(list!=null && list.length>0) {
		// if(list.length>0 && list!=null) { // 불가능
			System.arraycopy(list, 0, temp, 0, list.length);
		}
		list=temp;
	}
	
	@Override
	public int getCount() {
		return count;
	}
	
	@Override
	public ScoreVO[] listScore() {
		return list;
	}
	
	@Override
	public int append(ScoreVO vo) {
		if(count>=list.length) {
			// 배열의 꽉찬 경우 배열을 10개 늘리기
			allocation(list.length+10);
		}
		list[count++]=vo;
		
		return count;
	}
	
	@Override
	public double grade(int score) {
		double[] limit = {0,60,65,70,75,80,85,90,95};
		String[] ss= {"0","1.0","1.5","2.0","2.5","3.0","3.5","4.0","4.5"};

		ChoiceFormat cf=new ChoiceFormat(limit, ss);
		
		return Double.parseDouble(cf.format(score));
	}
	
	@Override
	public ScoreVO readScore(String hak) {
		ScoreVO vo=null;
		
		for(int i=0; i<count; i++) {
			if(list[i].getHak().equals(hak)) {
				vo=list[i];
				break;
			}
		}
		
		return vo;
	}
	
	@Override
	public int indexOf(String hak) {
		for(int i=0; i<count; i++) {
			if(list[i].getHak().equals(hak)) {
				return i;
			}
		}
		
		return -1;
	}
	
	@Override
	public boolean remove(String hak) {
		int idx=indexOf(hak);
		if(idx==-1)
			return false;
		
		for(int i=idx; i<count-1; i++) {
			list[i]=list[i+1];
		}
		list[--count]=null;
		
		return true;
	}
}
