
public class Dachshund extends HuntingDog{
private static Dachshund instance = null;
	
	private Dachshund(){
		super("�ڽ���Ʈ",30000);
		this.species = "�ڽ���Ʈ";
		this.skill = 3;
	}
	public static Dachshund getInstance(){
		if(instance == null) {
			instance = new Dachshund();
		}
		return instance;
	}
}
