
public class Fox extends Animal{
	public Fox(String name, int price) {
		super(name,price);
		this.where = Forest.getInstance();
		Forest.getInstance().animals.add(this);
//		this.setName("����");
//		this.setLevel(20);
//		this.setPrice(100);
//		this.setSpeed(50);
//		this.setWhere(Forest.getInstance()); // ������ �⺻ ��ġ : ��
	}
	@Override
	public void stunt() {
		System.out.println(this.getName()+ " �� ��۹�� ���� ��⸦ �մϴ�!");
	}

}
