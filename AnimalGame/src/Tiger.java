
public class Tiger extends Animal{
	
	public Tiger(String name, int price) {
		super(name, price);
		this.level = 80;
		this.speed = 300;
		this.where = Forest.getInstance();
		// ������ �⺻ ��ġ : ��
	}
	
	@Override
	public void stunt() {
		System.out.println("�Ϳ�! "+this.getName()+ "�� ���� ���� ���� ����մϴ�!");
	}
}
