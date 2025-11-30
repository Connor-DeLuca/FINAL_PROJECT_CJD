package mainPackage;
import java.util.ArrayList;

public class Inventory<T> {
	ArrayList<T> items;
	
	public Inventory() {
		items = new ArrayList<>();
	}
	
	public int getLength() {
		return items.size();
	}
	
	public T getItemByIndex(int index) {
		return items.get(index);
	}
	
	public T getItemByName(String name) {
		for(int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(name)) {
				return items.get(i);
			}
		}
		return null; // add error handling later
	}
	
	public void add(T item) {
		items.add(item);
	}
	
	public void remove(T item) {
		items.remove(item);
	}
	
}
