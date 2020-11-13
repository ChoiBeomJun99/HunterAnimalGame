import java.util.ArrayList;

public class Gym extends Map {
    
    private ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	private ArrayList<Protein> proteinList = new ArrayList<Protein>();
	
    public Gym(){
    	this.placename = "���ð�";
    	for(int i = 0; i < 50; i++) { // �ʱ���� 50����
    		ticketList.add(new Ticket());
    		proteinList.add(new Protein());
    		
    	}
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
}
