
public class Lion extends Animal{

	public Lion(String name, int price) {
		super(name, price);
		this.level = 50;
		this.speed = 90;
		this.where = Forest.getInstance(); // ������ �⺻ ��ġ : ��
	}
	
	@Override
	public void stunt() {
		System.out.println(this.getName()+ " ���� Ȳ�ݰ��⸦ �ֳ����ϴ�!");
	}
}
