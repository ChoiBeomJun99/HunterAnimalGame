
public class Sabsal extends HuntingDog {
private static Sabsal instance = null;
	
	private Sabsal(){
		super("��찳",70000);
		this.species = "��찳";
		this.skill = 7;
	}
	public static Sabsal getInstance(){
		if(instance == null) {
			instance = new Sabsal();
		}
		return instance;
	}
}
