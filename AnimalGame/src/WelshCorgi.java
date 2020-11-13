
public class WelshCorgi extends HuntingDog {
	private static WelshCorgi instance = null;
	
	private WelshCorgi(){
		super("À£½ÃÄÚ±â",50000);
		this.species = "À£½ÃÄÚ±â";
		this.skill = 5;
	}
	public static WelshCorgi getInstance(){
		if(instance == null) {
			instance = new WelshCorgi();
		}
		return instance;
	}
}
