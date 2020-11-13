
public class Main {
	public static void main(String[] args) {
		Fox f = new Fox("여순이",40000);
		Goat g = new Goat("염순이",30000);
		Gym gym= new Gym();
		GymManager.getInstance().sellTicket();
		GymManager.getInstance().sellTicket();
		GymManager.getInstance().sellProtein();
		GymManager.getInstance().sellProtein();
		GymManager.getInstance().sellProtein();
		GymManager.getInstance().checkTicket();
//		ShopManager.getInstance().sellHuntingDog(Chihuahua.getInstance());
//		ShopManager.getInstance().sellHuntingDog(WelshCorgi.getInstance());
//		Home.getInstance().show();
//		
		Hunter.getInstance().hunt(f);
		Hunter.getInstance().hunt(g);
		System.out.println(",,,,,");
		Hunter.getInstance().sellAnimal();
//		System.out.println();
//		Hunter.getInstance().hunt(f);
//		System.out.println(Hunter.getInstance().getHunterBag());
//		Forest.getInstance().show();
//		System.out.println(f.getWhere().placename);
//		System.out.println(g.where.placename);
//		System.out.println(g.where.placename);
	}
}
