package mainPackage;

public class KeyItem extends Item {
	
	public KeyItem(String name, String description) {
		super(name, description);
	}
	
	public void unlock(Room room) {
		room.setLocked(false);
	}

	
	
}
