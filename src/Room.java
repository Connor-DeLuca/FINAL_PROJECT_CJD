
import java.util.ArrayList;

/**
 * The abstract class which rooms are built of.
 * 
 * @author cdeluca
 */
public abstract class Room {
	private String name;
	private String description;
	private Entity entity;
	ArrayList<Item> items;
	private boolean isLocked;
	
	/**
	 * 
	 * @param name The room's unique name.
	 * @param description The room's description to be read by the user.
	 * @param entity The entity the player fights upon entering the room.
	 * @param items The items the player can find in the room.
	 * @param isLocked Whether the room can be entered at game start.
	 */
	public Room(String name, String description, Entity entity, ArrayList<Item> items, boolean isLocked) {
		this.name = name;
		this.description = description;
		this.entity = entity;
		this.items = items;
		this.isLocked = isLocked; 
	}
	
	/**
	 * Removes an item from items.
	 * 
	 * @param item The item to remove.
	 */
	public void removeItem(Item item) {
		items.remove(item);
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
