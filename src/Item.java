

/**
 * An abstract class which all types of items must inherit from.
 * 
 * @author cdeluca
 */
public abstract class Item {
	String name;
	String description;
	
	/**
	 * @param name The item's unique name.
	 * @param description The item's description to be read by the user.
	 */
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
