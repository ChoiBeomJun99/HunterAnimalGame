
public class WildPig extends Animal {

	public WildPig(String name, int price) {
		super(name,price);
		this.level = 20;
		this.speed = 60;
		this.where = Forest.getInstance();
		 // ������ �⺻ ��ġ : ��
	}	
	
	@Override
	public void stunt() {
		System.out.println(this.getName()+ " �� ������ ������ �ɰ��� ���¼ ���Դϴ�!");
	}
}
