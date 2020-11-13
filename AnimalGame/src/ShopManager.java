public class ShopManager {
	private static ShopManager sm;
	private int money; // Æê¼¥ÀÇ ÀÚ»ê
	private PetShop petshop;
	
	public static ShopManager getInstance() {
		if(sm == null) {
			sm = new ShopManager();
		}
		return sm;
	}
	public void sellHuntingDog(HuntingDog hdog) {
		System.out.println("Æê¼¥ °ü¸®ÀÚ´Â »ç³É²Û¿¡°Ô"+hdog.getPrice()+"À» ÁÖ°í "+hdog.getName()+"À» ÆË´Ï´Ù.");
    	this.money -= hdog.getPrice();
    	Hunter.getInstance().setMoney(Hunter.getInstance().getMoney()-hdog.getPrice());
    	System.out.println("Æê¼¥ °ü¸®ÀÚ¿¡°Ô ³²Àº µ· : "+this.money);
    	hdog.setWhere(Home.getInstance());
    	Home.getInstance().getHdog().add(hdog);
	}
}
