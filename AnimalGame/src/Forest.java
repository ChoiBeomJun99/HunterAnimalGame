import java.util.ArrayList;

public class Forest extends Map {
    
    private static Forest instance;
    
    private Forest(){
    	this.placename = "숲속";
    	this.animals = new ArrayList();
    }

    public static Forest getInstance(){
    	if(instance == null)
    		instance = new Forest();
        return instance;
    }
    
    public void play(){
    	System.out.println("숲속에서 동물들이 자유롭게 뛰어놉니다!!");
    	
    }

    public void hunt(){
    	System.out.println("숲속에서 동물들이 사냥을 합니다!! ");
    }
    public void show() {
    	for(int i = 0; i<animals.size(); i++) {
    		System.out.println(animals.get(i).getName());
    	}
    }
}
