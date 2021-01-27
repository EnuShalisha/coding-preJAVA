package score1;

public class ScoreVO {
	String name;
	int kor;
	int eng;
	int mat;
	
	public int tot() {
		return kor+eng+mat;
	}
	
	public double ave() {
		return (double)tot()/3;
	}
	
	public double grade(int score) {
		if (score>=95) 		return 4.5;
		else if(score>=90) 	return 4.0;
		else if(score>=85) 	return 3.5;
		else if(score>=80) 	return 3.0;
		else if(score>=75) 	return 2.5;
		else if(score>=70) 	return 2.0;
		else if(score>=65) 	return 1.5;
		else if(score>=60) 	return 1.0;
		else 				return 0.0; // 리턴이 없으면 오류
	}
	
	
	
}
