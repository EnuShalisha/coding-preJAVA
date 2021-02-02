package hw_0129;

public class Pw2nd {
	
	private static Pw2nd[][] list = new Pw2nd[10][10];
	
	private int bwd;
	
	public int getBwd() {
		return bwd;
	}

	public void setBwd(int bwd) {
		this.bwd = bwd;
	}
	
	public static String set(int i, int j) {
		int a=0, b=0;
		while(true) {
		a=(int) (Math.random()*10);
		b=(int) (Math.random()*10);
		if(list[a][b]==null) {
			Pw2nd pw = new Pw2nd();
			pw.setBwd(i*10+j);
			list[a][b]=pw;
			String c = Integer.toString(a)+Integer.toString(b);
			return c;
		}
	}
	}
	
	public static boolean confirmSnd(int sw, int pw) {
		int j=sw%10;
		int i=(sw-j)/10;
		Pw2nd bwd = new Pw2nd();
		bwd=list[i][j];
		if(bwd.getBwd()==pw)
			return true;
		return false;
	}
	
	public static void remove(int sw, int pw) {
		int j=sw%10;
		int i=(sw-j)/10;
		list[i][j]=null;
	}
}
