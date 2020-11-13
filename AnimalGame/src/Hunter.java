import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;

public class Hunter {
	private String name;
	private int workmanShip = 30;//수련장에서만
	private int Maxstamina;//프로틴으로
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
		this.name = "냥꾼이";
		this.stamina = 100;
		
	}
	public static Hunter getInstance() { //싱글턴
	
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
//		this.money = 10000;//초기 돈 만원
//		this.workmanShip = 10;//초기 숙련도 10 
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
				//잡으면
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
			System.out.println("사냥을 못합니다.");
			
		}
	}

	public void sellAnimal() {
		
		int n = this.hunterBag.element().key;
		if(zooManager.getInstance().getMoney() < n){
			System.out.println("거래을 할 수 없습니다.");
		}
		else {
//			System.out.println("hunter : "+this.getMoney());
//			System.out.println("zooM : "+zooManager.getInstance().getMoney());
			Pair tmp = this.hunterBag.remove(); // 사냥꾼 가방에서 빼고
			System.out.println(((Animal)(tmp.value)).getName());
			zooManager.getInstance().getZoo().animals.add(tmp.value); // 동물원에 넣음
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
			System.out.println("티켓의 개수가 0개 입니다.");
			System.out.println("들어갈 수  없습니다.");
		}
	}
	
	public void drinkProtein() {
		if(!(this.proteinList.isEmpty())) {
			this.proteinList.remove(this.proteinList.size()-1);
			this.stamina ++;
		}else
			System.out.println("프로틴의 개수가 0개 입니다.");
			System.out.println("먹을 수 없습니다.");
	}
	
	public void rest() {
		this.stamina = 100; //최대 체력을 100으로 설정해보았습니다. 
	}
	
	public void buyProtein() {
		// protein 가격을 10000원이라고 가정
		if(this.money>=10000) {
			this.money -= 10000;
			Protein e = new Protein();
			this.proteinList.add(e);
		}else {
			System.out.println("현재 " + this.money + "원이 있습니다.");
			System.out.println("프로틴을 살 수 없습니다.");
		}
	}
	
	public void buyTicket() {
		//티켓의 가격을 20000원 이라고 가정
		if(this.money>=20000) {
			this.money -=20000;
			Ticket e = new Ticket();
			this.ticketList.add(e);
		}
		else {
			System.out.println("현재 " + this.money + "원이 있습니다.");
			System.out.println("티켓을 살 수 없습니다.");
		}
	}
	
	public void buyHuntingDog(HuntingDog hdog) {
		if(this.money >= hdog.getPrice()) {
			Home.getInstance().getHdog().add(hdog);
			this.money = this.money - hdog.getPrice();
		}
		else {
			System.out.println(hdog.getName() + "을(를) 살 돈이 부족합니다.");
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
