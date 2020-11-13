
public class Tiger extends Animal{
	
	public Tiger(String name, int price) {
		super(name, price);
		this.level = 80;
		this.speed = 300;
		this.where = Forest.getInstance();
		// 생성시 기본 위치 : 숲
	}
	
	@Override
	public void stunt() {
		System.out.println("와우! "+this.getName()+ "가 불이 붙은 링을 통과합니다!");
	}
}
