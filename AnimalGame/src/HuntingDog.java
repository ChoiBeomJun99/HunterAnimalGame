public abstract class HuntingDog{
	protected String name;
	protected String species;
	protected Map where;
	protected int skill;
	protected int price;

	public HuntingDog(String name, int price) {
		this.name = name;
		this.price = price;
	}	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpecies(String species) {
		this.species = species;
	}	
	public String getSpecies() {
		return this.species;
	}
	public int getSkill() {
		return skill;
	}
	public void setSkill(int skill) {
		this.skill = skill;
	}
	public Map getWhere() {
		return where;
	}
	public void setWhere(Map where) {
		this.where = where;
	}
}
