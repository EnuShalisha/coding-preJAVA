package score2;
// VO : value object 한 사람의 정보를 저장하는 객체
public class ScoreVO {
		// 스테이터스
		private String hak; // 게터 세터 존재의 이유 - 코드의 99퍼는 인스턴스 변수를 프라이빗으로 놓음
		private String name; // 이때 게터를 퍼블릭으로 둬서 사용자로부터 인수를 받고 그걸 private으로 넘기는게 세터
		private int kor; // 그리고 필드의 이름은 무조건 소문자로 할것 - 이게 규약임
		private int eng;
		private int mat;
		
		public String getHak() {
			return hak;
		}
		public void setHak(String hak) {
			this.hak = hak;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getKor() {
			return kor;
		}
		public void setKor(int kor) {
			this.kor = kor;
		}
		public int getEng() {
			return eng;
		}
		public void setEng(int eng) {
			this.eng = eng;
		}
		public int getMat() {
			return mat;
		}
		public void setMat(int mat) {
			this.mat = mat;
		} // 여기까지 변수들은 this를 통해 private 필드에 저장됨
		
		public int getTot() {
			return kor+eng+mat;
		}
		
		public int getAve() {
			return getTot()/3;
		}

		

}
