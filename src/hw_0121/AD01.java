package hw_0121;

public class AD01 {

	public static void main(String[] args) {
		int n=0, s=0;
		while(s<100) {
			n++;
			if(n%2!=0) 
				s+=n;
			
			else
				s-=n;
		}
		System.out.printf("n : %d, s: %d",n,s);
	}

}
