import java.util.ArrayList;

public class Forest extends Map {
    
    private static Forest instance;
    
    private Forest(){
    	this.placename = "����";
    	this.animals = new ArrayList();
    }

    public static Forest getInstance(){
    	if(instance == null)
    		instance = new Forest();
        return instance;
    }
    
    public void play(){
    	System.out.println("���ӿ��� �������� �����Ӱ� �پ��ϴ�!!");
    	
    }

    public void hunt(){
    	System.out.println("���ӿ��� �������� ����� �մϴ�!! ");
    }
    public void show() {
    	for(int i = 0; i<animals.size(); i++) {
    		System.out.println(animals.get(i).getName());
    	}
    }
}
