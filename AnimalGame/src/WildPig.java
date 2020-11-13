
public class WildPig extends Animal {

	public WildPig(String name, int price) {
		super(name,price);
		this.level = 20;
		this.speed = 60;
		this.where = Forest.getInstance();
		 // 생성시 기본 위치 : 숲
	}	
	
	@Override
	public void stunt() {
		System.out.println(this.getName()+ " 가 수박을 반으로 쪼개는 차력쇼를 보입니다!");
	}
}
