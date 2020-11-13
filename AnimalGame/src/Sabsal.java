
public class Sabsal extends HuntingDog {
private static Sabsal instance = null;
	
	private Sabsal(){
		super("»ð»ì°³",70000);
		this.species = "»ð»ì°³";
		this.skill = 7;
	}
	public static Sabsal getInstance(){
		if(instance == null) {
			instance = new Sabsal();
		}
		return instance;
	}
}
