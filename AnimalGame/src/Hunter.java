import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;

public class Hunter {
	private String name;
	private int workmanShip = 30;//�����忡����
	private int Maxstamina;//����ƾ����
	private int stamina;
	private PriorityQueue<Pair> hunterBag = new PriorityQueue<Pair>();
	private int money;
	private ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
    private ArrayList<Protein> proteinList = new ArrayList<Protein>();
	private Map where;
	private int skill; 
	private HuntingDog selectedDog;
	private Home home = new Home();
	
	public static class Pair implements Comparable<Pair> {
        public Animal value;
        public Integer key;
 
        public Pair(Integer key, Animal value) {
            this.key   = key;
            this.value = value;
        }
 
        @Override
        public int compareTo(Pair o) {
            if (this.key < o.key)
                return 1;
            else if (this.key > o.key)
                return -1;
            return 0;
        }
    }

	private static Hunter h = null;
	private Hunter() {
		this.name = "�ɲ���";
		this.stamina = 100;
		
	}
	public static Hunter getInstance() { //�̱���
	
		if(h ==null) {
			h = new Hunter();
		}
		return h;
	}
//	public Hunter(String name) {
//		this.name = name;
//		this.Maxstamina = 100;
//		this.stamina = 100;
//		this.hunterBag = null;
//		this.ticketNum = 0;
//		this.proteinNum = 0;
//		this.money = 10000;//�ʱ� �� ����
//		this.workmanShip = 10;//�ʱ� ���õ� 10 
//		this.hdog = null;
//	}

	public void selectHuntingDog(HuntingDog hdog) {
		this.selectedDog = hdog;
	}
	public void hunt(Animal ani) {
		if(ani.level <= this.workmanShip) {
			if(this.selectedDog != null) {
				int temp = selectedDog.getSkill() + this.skill;
				ani.setSpeed(ani.getSpeed()-temp);
				//������
				this.hunterBag.add(new Pair(ani.getPrice(),ani));
				ani.setWhere(home);
				this.stamina -= 5;
				
			}
			else {
				ani.setSpeed(ani.getSpeed()-this.skill);
				this.hunterBag.add(new Pair(ani.getPrice(),ani));
				this.stamina -= 5;
				}
		}
		else {
			System.out.println("����� ���մϴ�.");
			
		}
	}

	public void sellAnimal() {
		
		int n = this.hunterBag.element().key;
		if(zooManager.getInstance().getMoney() < n){
			System.out.println("�ŷ��� �� �� �����ϴ�.");
		}
		else {
//			System.out.println("hunter : "+this.getMoney());
//			System.out.println("zooM : "+zooManager.getInstance().getMoney());
			Pair tmp = this.hunterBag.remove(); // ��ɲ� ���濡�� ����
			System.out.println(((Animal)(tmp.value)).getName());
			zooManager.getInstance().getZoo().animals.add(tmp.value); // �������� ����
			tmp.value.setWhere(zooManager.getInstance().getZoo());
			System.out.println(zooManager.getInstance().getZoo().animals.get(0).getName());
			this.money += tmp.value.price; 
			zooManager.getInstance().setMoney(zooManager.getInstance().getMoney()-tmp.value.price);
//			System.out.println("hunter : "+this.getMoney());
//			System.out.println("zooM : "+zooManager.getInstance().getMoney());
		}
	}
	
	public void train() {
		if(!(this.ticketList.isEmpty())) {
			this.ticketList.remove(this.ticketList.size()-1);
			this.workmanShip++;
		}else {
			System.out.println("Ƽ���� ������ 0�� �Դϴ�.");
			System.out.println("�� ��  �����ϴ�.");
		}
	}
	
	public void drinkProtein() {
		if(!(this.proteinList.isEmpty())) {
			this.proteinList.remove(this.proteinList.size()-1);
			this.stamina ++;
		}else
			System.out.println("����ƾ�� ������ 0�� �Դϴ�.");
			System.out.println("���� �� �����ϴ�.");
	}
	
	public void rest() {
		this.stamina = 100; //�ִ� ü���� 100���� �����غ��ҽ��ϴ�. 
	}
	
	public void buyProtein() {
		// protein ������ 10000���̶�� ����
		if(this.money>=10000) {
			this.money -= 10000;
			Protein e = new Protein();
			this.proteinList.add(e);
		}else {
			System.out.println("���� " + this.money + "���� �ֽ��ϴ�.");
			System.out.println("����ƾ�� �� �� �����ϴ�.");
		}
	}
	
	public void buyTicket() {
		//Ƽ���� ������ 20000�� �̶�� ����
		if(this.money>=20000) {
			this.money -=20000;
			Ticket e = new Ticket();
			this.ticketList.add(e);
		}
		else {
			System.out.println("���� " + this.money + "���� �ֽ��ϴ�.");
			System.out.println("Ƽ���� �� �� �����ϴ�.");
		}
	}
	
	public void buyHuntingDog(HuntingDog hdog) {
		if(this.money >= hdog.getPrice()) {
			Home.getInstance().getHdog().add(hdog);
			this.money = this.money - hdog.getPrice();
		}
		else {
			System.out.println(hdog.getName() + "��(��) �� ���� �����մϴ�.");
		}
	}
	
	public void letgoAnimal(Animal ani) {
		hunterBag.remove(ani);
		ani.setWhere(Forest.getInstance());
		
	}
	
	
	public HuntingDog getSelectedDog() {
		return selectedDog;
	}
	public void setSelectedDog(HuntingDog selectedDog) {
		this.selectedDog = selectedDog;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getWorkmanShip() {
		return workmanShip;
	}
	
	public void setWorkmanShip(int workmanShip) {
		this.workmanShip = workmanShip;
	}
	
	public int getStamina() {
		return stamina;
	}
	
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	public PriorityQueue<Pair> getHunterBag() {
		return hunterBag;
	}
	
	public void setHunterBag(PriorityQueue<Pair> hunterBag) {
		this.hunterBag = hunterBag;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public ArrayList<Protein> getProteinList() {
		return proteinList;
	}

	public void setProteinList(ArrayList<Protein> proteinList) {
		this.proteinList = proteinList;
	}

	public Map getWhere() {
		return where;
	}
	public void setWhere(Map where) {
		this.where = where;
	}
}
