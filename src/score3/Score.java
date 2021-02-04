package score3;

import java.text.ChoiceFormat;

public class Score {
	private ScoreVO[]list;
	private int count;
	
	public Score() {
		allocation(10); // 초기에 10 배열 메모리
	}
	
	private void allocation(int capacity) {
		ScoreVO[] temp = new ScoreVO[capacity];
		if(list!=null&&list.length>0 ) {
			//list.length>0&&list!=null 일 경우, 초기엔 list가 null이기때문에 nullpointexception
			//그래서 무조건 널 비교가 먼저
			System.arraycopy(list, 0, temp, 0, list.length);
		}
		list=temp;
	}
	
	public int getCount() {
		return count;
	}
	public ScoreVO[] listScore() {
		return list;
	}
	
	public int append(ScoreVO vo) {
		if(count>=list.length) {
			//배열이 꽉찬경우
			allocation(list.length+10);
		}
		list[count++]=vo;
		return count;
	}
	
	public double grade(int score) {
		String p="0#0.0|60#1.0|65#1.5|70#2.0|75#2.5|80#3.0|85#3.5|90#4.0|95#4.5";
		ChoiceFormat cf = new ChoiceFormat(p);
		
		return Double.parseDouble(cf.format(score));
	}
	
	public ScoreVO readScore(String hak) {
		ScoreVO vo = null;
		
		for(int i=0; i<count; i++) {
			if(list[i].getHak().equals(hak)) {
				vo=list[i];
				break;
			}
		}
		return vo;
	}
	
	public int indexOf(String hak) {
		
		for(int i=0; i<count; i++) {
			if(list[i].getHak().equals(hak))
				return i;
		}
		return -1;
	}
	
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
