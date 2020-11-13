
public class Lion extends Animal{

	public Lion(String name, int price) {
		super(name, price);
		this.level = 50;
		this.speed = 90;
		this.where = Forest.getInstance(); // 생성시 기본 위치 : 숲
	}
	
	@Override
	public void stunt() {
		System.out.println(this.getName()+ " 멋진 황금갈기를 휘날립니다!");
	}
}
