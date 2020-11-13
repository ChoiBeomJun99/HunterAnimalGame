
public class Chihuahua extends HuntingDog{
private static Chihuahua instance = null;
	
	private Chihuahua(){
		super("치와와",10000);
		this.species = "웰시코기";
		this.skill = 1;
	}
	public static Chihuahua getInstance(){
		if(instance == null) {
			instance = new Chihuahua();
		}
		return instance;
	}
}
