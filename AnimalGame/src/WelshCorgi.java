
public class WelshCorgi extends HuntingDog {
	private static WelshCorgi instance = null;
	
	private WelshCorgi(){
		super("�����ڱ�",50000);
		this.species = "�����ڱ�";
		this.skill = 5;
	}
	public static WelshCorgi getInstance(){
		if(instance == null) {
			instance = new WelshCorgi();
		}
		return instance;
	}
}
