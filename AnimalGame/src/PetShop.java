import java.util.ArrayList;

public class PetShop extends Map{
	private static PetShop instance = null;

	private PetShop() {
		this.placename = "Æê¼¥";
		this.animals = new ArrayList();
	}
	public static PetShop getInstance() {
		if(instance == null) {
			instance = new PetShop();
		}
		return instance;
	}
	public void show() {
		for(int i = 0; i<animals.size(); i++) {
			System.out.println(animals.get(i).getName());
		}
	}
	
	
}
