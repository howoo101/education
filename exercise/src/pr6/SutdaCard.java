package pr6;

public class SutdaCard {
	public int num;
	public boolean isKwang;

	public SutdaCard() {
		this.num = 1;
		this.isKwang = true;
	}
	
	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String info() {
		if (this.isKwang == true) return this.num + "K";
		else return this.num +"";
	}
}

