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
		System.out.println("������ : "+ where.placename);
	}
	public void setWhere(Map m) {// hunter->ZooManager only
		this.where = m;
		this.liveIn(m);
		System.out.println(this.name+"��"+m.placename +"���� ��� �˴ϴ�.");
	}
//	
//	public void setWhere(Forest forest) { // hunter->Forest or escape?
//		this.where = forest;
//		Hunter.getInstance().getHunterBag().remove(this); // ������ ���濡�� �� ���� lose
//		Forest.getInstance().animals.add(this);
//		System.out.println(this.name+"�� �� �ӿ��� ��� �˴ϴ�.");
//	}
//	public void setWhere() {
//		this.where = null;
//	}
	
	
	public Map getWhere() {
		return this.where;
	}

	public void stunt() {
		System.out.println(this.name+" ���⸦ �θ��ϴ�!");
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
