package hw_4_0215;

public class Vending {
	
	private stockVO vo;
	
	
	public void 음료 등록(String 음료) {
		if 음료 있어
			수정 들어갈까?
			if yes	수정 메소드
			else 이미 존재해 리턴
		}
		set 음료
		가격 얼마?
		set 가격
		배치순서는 이렇게있어
		get 배치순서
		몇번으로 할래?
		set 배치순서
		if 이미 존재
			{배치순서 메소드
			리턴}
		완료
	}
	
	public void 음료 삽입(String 음료) {
		몇개 넣을래?
		set 갯수
		됐어
		리턴;
	}
		
	public StockVO 배치순서
		{배치순서리스트: 음료 있을경우, 순서, 음료, 수량 ln
		return 배치순서 리스트;}
	
	
	public void 배치순서 바꾸기(String 음료){
		get 배치순서리스트;
		몇번으로 바꿀래?
		set 순서
		if (순서에 다른음료가 없다면)
			{완료됐어
			리턴}
		배치순서 찐바꾸기(int 바꾼순서, int 원래순서);
	}
	
	public void 배치순서 찐바꾸기(int 바꾼순서, int 원래순서) {
		if (원래순서=바뀐순서)
			같아
			리턴	
		else if (원래순서>바뀐순서)
			/*3 4 5 6 7 8
			8->3
			  8 3 4 5 6 7*/
			
			이렇게하면 (원래순서)와 (바꾼순서) 사이의 x개 음료의 순서 뒤로 밀려날거야. 괜찮아?
		else
			/*3 4 5 6 7 8
			3->8
			  4 5 6 7 8 3*/
			이렇게하면 (원래순서)와 (바꾼순서) 사이의 x개 음료의 순서 앞으로 당겨질거야. 괜찮아?
		if ㅇㅋ 입력
			바꾸고
			리턴
		리턴
	}
	
	public void 음료 삭제하기(String 음료) {
		이 음료를 삭제할거야. 정말이야?
		get 음료VO들;
		if ㅇㅋ
		삭제 완료
	}
	
	public void 잔돈 유무() {
		get 잔돈;
		얼마 채울래?
		500원짜리 몇개 100원짜리 몇개
		set 잔돈;
		완료}
	
	public void 비밀번호 설정(String 새비밀번호) {
		set 비밀번호
		완료
}
