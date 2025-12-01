package mainPackage;
import java.util.ArrayList;

/**
 * Stores the user's inventory in an arraylist of items with useful methods.
 * 
 * @author cdeluca
 */
public class Inventory {
	ArrayList<Item> items;
	
	/**
	 * Initializes the empty inventory.
	 */
	public Inventory() {
		items = new ArrayList<>();
	}
	
	/**
	 * Returns the inventory's size.
	 * 
	 * @return The number of objects in items.
	 */
	public int getLength() {
		return items.size();
	}
	
	/**
	 * Returns an object from items by a specific index.
	 * 
	 * @param index The index to retrieve.
	 * @return The Item stored there.
	 */
	public Item getItemByIndex(int index) {
		return items.get(index);
	}
	
	/**
	 * Returns an item by its name variable.
	 * 
	 * @param name The String to search for.
	 * @return The Item with that name.
	 */
	public Item getItemByName(String name) {
		for(int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(name)) {
				return items.get(i);
			}
		}
		return null;
	}

	/**
	 * Adds an item to items.
	 * 
	 * @param item An Item object to append to items.
	 */
	public void add(Item item) {
		items.add(item);
	}
	
	/**
	 * Removes an item from items.
	 * 
	 * @param item The item to remove.
	 */
	public void remove(Item item) {
		items.remove(item);
	}
	
	
}
