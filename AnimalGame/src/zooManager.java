public class zooManager {
	private static zooManager zm;
    private int money = 500000; //임의로 정해놈
    private Zoo zoo = new Zoo();
    public static zooManager getInstance() {
    	if (zm == null) {
    		zm = new zooManager();
    	}
    	return zm;
    
    }

    public Zoo getZoo() {
		return zoo;
	}
	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}
	
    public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
