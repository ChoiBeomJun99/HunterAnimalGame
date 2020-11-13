import java.io.IOException;

public class GymManager {
	private static GymManager instance = null;
	private String name;
	private Gym gym = new Gym();
	
	private GymManager() {
		this.name = "���ð� �Ŵ���";
	}
	public static GymManager getInstance() {
		if(instance == null) {
			instance = new GymManager();
		}
		return instance;
	}
	
	public void sellTicket() {
		if(gym.getTicketList().size() == 0) {
			System.out.println("Ƽ���� ���� �� �� �����ϴ�.]");
		}
		else {
			Ticket t = gym.getTicketList().remove(gym.getTicketList().size()-1);
			Hunter.getInstance().getTicketList().add(t);
//
			
			System.out.println("���Ͱ� Ƽ�� 1���� �����߽��ϴ�." + "���� ������ Ƽ�� ���� : " + Hunter.getInstance().getTicketList().size());
		}
	}
	public void sellProtein() {
		if(gym.getProteinList().size() == 0) {
			System.out.println("Ƽ���� ���� �� �� �����ϴ�.");
		}
		else {
			Protein t = gym.getProteinList().remove(gym.getProteinList().size()-1);
			Hunter.getInstance().getProteinList().add(t);
			System.out.println("���Ͱ� ����ƾ�� 1�� �����߽��ϴ�. ���� ������ ����ƾ ���� : "+ Hunter.getInstance().getProteinList().size());
		}
	}
	public void checkTicket() {
		if(Hunter.getInstance().getTicketList().size() == 0) {
			System.out.println("������ �� �� �����ϴ�.");
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
