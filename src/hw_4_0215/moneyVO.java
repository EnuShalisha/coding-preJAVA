package hw_4_0215;

public class moneyVO {

		private int thousand;
		private int hundred;
		private int ten;
		private int one;
		private int total;
		public int getTotal() {
			return total;
		}
		public void setTotal() {
			this.total=thousand*1000+hundred*100+ten*10+one*1;
		}
		public int getThousand() {
			return thousand;
		}
		public void setThousand(int thousand) {
			this.thousand = thousand;
		}
		public int getHundred() {
			return hundred;
		}
		public void setHundred(int hundred) {
			this.hundred = hundred;
		}
		public int getTen() {
			return ten;
		}
		public void setTen(int ten) {
			this.ten = ten;
		}
		public int getOne() {
			return one;
		}
		public void setOne(int one) {
			this.one = one;
		}
		

	}
