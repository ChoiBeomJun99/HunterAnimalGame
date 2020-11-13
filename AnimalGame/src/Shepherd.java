
public class Shepherd extends HuntingDog{
	private static Shepherd instance = null;
	
	private Shepherd(){
		super("¼ÎÆÛµå",100000);
		this.species = "¼ÎÆÛµå";
		this.skill = 10;
	}
	public static Shepherd getInstance(){
		if(instance == null) {
			instance = new Shepherd();
		}
		return instance;
	}
}
