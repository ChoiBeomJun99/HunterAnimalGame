public class ShopManager {
	private static ShopManager sm;
	private int money; // �꼥�� �ڻ�
	private PetShop petshop;
	
	public static ShopManager getInstance() {
		if(sm == null) {
			sm = new ShopManager();
		}
		return sm;
	}
	public void sellHuntingDog(HuntingDog hdog) {
		System.out.println("�꼥 �����ڴ� ��ɲۿ���"+hdog.getPrice()+"�� �ְ� "+hdog.getName()+"�� �˴ϴ�.");
    	this.money -= hdog.getPrice();
    	Hunter.getInstance().setMoney(Hunter.getInstance().getMoney()-hdog.getPrice());
    	System.out.println("�꼥 �����ڿ��� ���� �� : "+this.money);
    	hdog.setWhere(Home.getInstance());
    	Home.getInstance().getHdog().add(hdog);
	}
}
