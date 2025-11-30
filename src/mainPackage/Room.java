package mainPackage;
import java.util.ArrayList;

public abstract class Room {
	private String name;
	private String description;
	private Entity entity;
	ArrayList<Item> items;
	private boolean isLocked;
	
	public Room(String name, String description, Entity entity, ArrayList<Item> items, boolean isLocked) {
		this.name = name;
		this.description = description;
		this.entity = entity;
		this.items = items;
		this.isLocked = isLocked; 
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public Item getItem(int index) {
		return items.get(index);
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

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	
}
