package com.ex0125;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String o=""; //String������ ���ǵ� �Ϳ� �ָ�
		z: //z:�� �󺧸��̴�
		for(int x=0; x<3; x++) {
		    for(int y=0; y<2; y++) { // y=2�� �� for������ back
		        if(x==1) break; // x=1 ���ڸ��� for�� break
		        if(x==2 && y==1) break z; // 20������ �ؿ� ����, 21�� z for�� break
		        o=o+x+y; // xy = 00, 01, 20
		    }
		}
		}
	    }
	


