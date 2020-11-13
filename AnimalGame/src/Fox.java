
public class Fox extends Animal{
	public Fox(String name, int price) {
		super(name,price);
		this.where = Forest.getInstance();
		Forest.getInstance().animals.add(this);
//		this.setName("여우");
//		this.setLevel(20);
//		this.setPrice(100);
//		this.setSpeed(50);
//		this.setWhere(Forest.getInstance()); // 생성시 기본 위치 : 숲
	}
	@Override
	public void stunt() {
		System.out.println(this.getName()+ " 가 뱅글뱅글 꼬리 잡기를 합니다!");
	}

}
