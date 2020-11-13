
public class Dachshund extends HuntingDog{
private static Dachshund instance = null;
	
	private Dachshund(){
		super("´Ú½ºÈÆÆ®",30000);
		this.species = "´Ú½ºÈÆÆ®";
		this.skill = 3;
	}
	public static Dachshund getInstance(){
		if(instance == null) {
			instance = new Dachshund();
		}
		return instance;
	}
}
