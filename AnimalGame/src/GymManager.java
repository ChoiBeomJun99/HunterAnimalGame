import java.io.IOException;

public class GymManager {
	private static GymManager instance = null;
	private String name;
	private Gym gym = new Gym();
	
	private GymManager() {
		this.name = "수련관 매니저";
	}
	public static GymManager getInstance() {
		if(instance == null) {
			instance = new GymManager();
		}
		return instance;
	}
	
	public void sellTicket() {
		if(gym.getTicketList().size() == 0) {
			System.out.println("티켓을 구매 할 수 없습니다.]");
		}
		else {
			Ticket t = gym.getTicketList().remove(gym.getTicketList().size()-1);
			Hunter.getInstance().getTicketList().add(t);
//
			
			System.out.println("헌터가 티켓 1개를 구매했습니다." + "현재 헌터의 티켓 갯수 : " + Hunter.getInstance().getTicketList().size());
		}
	}
	public void sellProtein() {
		if(gym.getProteinList().size() == 0) {
			System.out.println("티켓을 구매 할 수 없습니다.");
		}
		else {
			Protein t = gym.getProteinList().remove(gym.getProteinList().size()-1);
			Hunter.getInstance().getProteinList().add(t);
			System.out.println("헌터가 프로틴을 1개 구매했습니다. 현재 헌터의 프로틴 갯수 : "+ Hunter.getInstance().getProteinList().size());
		}
	}
	public void checkTicket() {
		if(Hunter.getInstance().getTicketList().size() == 0) {
			System.out.println("수련을 할 수 없습니다.");
		}
		else {
			int tmp = Hunter.getInstance().getTicketList().size()-1;
			Ticket t = Hunter.getInstance().getTicketList().remove(tmp);
			gym.getTicketList().add(t);
//			System.out.println(Hunter.getInstance().getTicketList().size());
//			System.out.println(gym.getTicketList().size());
		}
	}
	
	
}
