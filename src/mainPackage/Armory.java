package mainPackage;
import java.util.ArrayList;

public class Armory extends Room {
	
	public Armory(String name, String description, Entity entity, ArrayList<Item> items, boolean isLocked) {
		super(name, description, entity, items, isLocked);
	}

}
