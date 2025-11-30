package mainPackage;
import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> items;
	
	public Inventory() {
		items = new ArrayList<>();
	}
	
	public int getLength() {
		return items.size();
	}
	
	public Item getItemByIndex(int index) {
		return items.get(index);
	}
	
	public Item getItemByName(String name) {
		for(int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(name)) {
				return items.get(i);
			}
		}
		return null; // add error handling later
	}
	
	public void add(Item item) {
		items.add(item);
	}
	
	public void remove(Item item) {
		items.remove(item);
	}
	
	
}
