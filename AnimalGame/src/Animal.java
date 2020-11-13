public abstract class Animal{
	protected String name;
	protected Map where;
	protected int price;
	protected int speed;
	protected int level;
	
	public Animal(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public void liveIn(Map w) {
		this.where = w;
		System.out.println("서식지 : "+ where.placename);
	}
	public void setWhere(Map m) {// hunter->ZooManager only
		this.where = m;
		this.liveIn(m);
		System.out.println(this.name+"은"+m.placename +"에서 살게 됩니다.");
	}
//	
//	public void setWhere(Forest forest) { // hunter->Forest or escape?
//		this.where = forest;
//		Hunter.getInstance().getHunterBag().remove(this); // 헌터의 가방에서 한 마리 lose
//		Forest.getInstance().animals.add(this);
//		System.out.println(this.name+"은 숲 속에서 살게 됩니다.");
//	}
//	public void setWhere() {
//		this.where = null;
//	}
	
	
	public Map getWhere() {
		return this.where;
	}

	public void stunt() {
		System.out.println(this.name+" 묘기를 부립니다!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
