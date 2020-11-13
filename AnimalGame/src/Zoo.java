import java.util.ArrayList;
public class Zoo extends Map {
	
//    private static Zoo instance = null;
    
    public Zoo(){
    	this.placename = "µ¿¹°¿ø";
    	this.animals = new ArrayList();
    }
//    public static Zoo getInstance(){
//    	if(instance == null) {
//    		instance = new Zoo();
//    	}
//	return instance;
//    }
   
    public void show() {
    	for(int i = 0; i<animals.size(); i++) {
    		System.out.println(animals.get(i));
    	}
    }
}
