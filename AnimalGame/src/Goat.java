
public class Goat extends Animal {
	
	public Goat(String name, int price) {
		super(name, price);
		this.level = 10;
		this.speed = 30;
		this.where = Forest.getInstance(); // ������ �⺻ ��ġ : ��
		Forest.getInstance().animals.add(this);
	}	
	
	@Override
	public void stunt() {
		System.out.println(this.getName()+ " �� �Թ�ġ�⸦ �ϸ� ��ǽ��� �˳��ϴ�!");
	}
}
