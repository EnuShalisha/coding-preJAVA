package score2;
//목적: 입력정보를 주기억장치에 저장
public class Score {
	private ScoreVO[] list = new ScoreVO[10];
	private int count; // scoreui 메소드에서도 접근하지 않도록 private
	//그 다음 리턴을 할 수 있도록 밑에
	
	public int append(ScoreVO vo) { // 질문 3. 어차피 ScoreVO 형태로 저장될거면 왜 어펜드를 score 클래스에 넣는가
		//물어보면서 인스턴스에 대한 이해 넓히기
		if(count>=10) {
			return -1;
		} // 여기까지 list[0] 값 null
		list[count] = vo; // 리스트 배열에 저장 -> 4 리스트랑 3 검색은 이걸 불러옴
		count++; // 질문 2(s). vo에 받은 변수들이 어떻게 자동으로 배열로 저장되는가? - 변수들이 배열화가 되는게 아니라 인스턴스의 필드가 되는거임
		return count; // 리턴값이 -1이 아니면 ui에서 '변수 저장 완료'를 return하게됨
	}
	public ScoreVO readScore(String hak) {
		ScoreVO vo=null;
		
		for(int i=0; i<count; i++) {
			ScoreVO v = list[i]; // 임의의 v 인스턴스로 리스트를 불러옴
			if(v.getHak().equals(hak)) { // v의 hak과 ui의 hak을 비교
				//if(v.getHak==hak) // 문자열을 ==로 비교하면 값이 아니라 주소 비교
				// 그대로 break될 수밖에 없음
				//문자열 비교 메소드 equals(hak)
				vo=v; // score UI의 vo에 v 배열 저장
				break;
			}
		}
		return vo; // scoreUI로 넘어감
	}
	public int getCount() {
		return count;
	}
	public ScoreVO[] listScore() {
		return list; // 등록을 진행했으면 list 도메인에 저장돼있음
		// private였던 list를 불러옴
	}
	
}
