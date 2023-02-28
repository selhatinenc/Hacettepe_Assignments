
public class Banker extends People {
	private int money ;
	public Banker() {
		money=100000;
		
		
	}
	public void setmoney(int number) {
		money=money+number;
	}
	public int getmoney() {
		return money;
	}

	
}
