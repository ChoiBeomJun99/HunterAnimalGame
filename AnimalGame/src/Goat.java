
public class Goat extends Animal {
	
	public Goat(String name, int price) {
		super(name, price);
		this.level = 10;
		this.speed = 30;
		this.where = Forest.getInstance(); // »ý¼º½Ã ±âº» À§Ä¡ : ½£
		Forest.getInstance().animals.add(this);
	}	
	
	@Override
	public void stunt() {
		System.out.println(this.getName()+ " °¡ »Ô¹ÚÄ¡±â¸¦ ÇÏ¸ç ¼î¸Ç½ÊÀ» »Ë³À´Ï´Ù!");
	}
}
