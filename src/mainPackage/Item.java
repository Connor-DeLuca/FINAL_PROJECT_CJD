package mainPackage;

public abstract class Item {
	String name;
	String description;
	
	// FIND A WAY TO USE INTERFACES
	
	public Item (String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
