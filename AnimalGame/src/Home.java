import java.util.ArrayList;

public class Home extends Map {
	private ArrayList <HuntingDog> hdog = new ArrayList<HuntingDog>();
	
	private static Home instance = null;

    public Home(){
    	this.placename = "사냥꾼 집";
    }
    public static Home getInstance(){
    	if(instance == null) {
    		instance = new Home();
    	}
    	return instance;
    }
    public ArrayList<HuntingDog> getHdog() {
		return hdog;
	}
	public void setHdog(ArrayList<HuntingDog> hdog) {
		this.hdog = hdog;
	}
    public void pulsListDog(HuntingDog hdog) {
    	this.hdog.add(hdog);
    }
    public void getListDog(HuntingDog hdog) {
    	this.hdog.remove(hdog);
    	if(Hunter.getInstance().getSelectedDog() != null) {
    		this.hdog.add(Hunter.getInstance().getSelectedDog());
    		Hunter.getInstance().selectHuntingDog(hdog);
    	}
    	else {
    		Hunter.getInstance().selectHuntingDog(hdog);
    	}
    	
    }
    public void show() {
    	for(int i = 0; i<hdog.size(); i++) {
    		System.out.println(hdog.get(i).getName());
    	}
    }
    public void heal() {
    	Hunter.getInstance().setStamina(100);//헌터의 스테미나를 최대로 만들어줌..
    }
}
