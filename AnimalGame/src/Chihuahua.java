
public class Chihuahua extends HuntingDog{
private static Chihuahua instance = null;
	
	private Chihuahua(){
		super("ġ�Ϳ�",10000);
		this.species = "�����ڱ�";
		this.skill = 1;
	}
	public static Chihuahua getInstance(){
		if(instance == null) {
			instance = new Chihuahua();
		}
		return instance;
	}
}
