
public class Shepherd extends HuntingDog{
	private static Shepherd instance = null;
	
	private Shepherd(){
		super("���۵�",100000);
		this.species = "���۵�";
		this.skill = 10;
	}
	public static Shepherd getInstance(){
		if(instance == null) {
			instance = new Shepherd();
		}
		return instance;
	}
}
