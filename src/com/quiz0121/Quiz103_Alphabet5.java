package com.quiz0121;
public class Quiz103_Alphabet5 {
	public static void main(String[] args) {
/*		
		A~Z 까지의 영문자를 한 줄에 5개씩 출력
*/
		char ch='A';
		int cnt;
		
		cnt=0;
		while(ch<='Z') {
			System.out.print(ch+"\t");
			
			cnt++;
			if(cnt==5) {
				System.out.println();
				cnt=0;
			}
			
			ch++;
		}
	}
}
