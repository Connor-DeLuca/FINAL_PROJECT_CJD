package mainPackage;

public class KeyItem extends Item {
	private Room roomToUnlock;
	
	public KeyItem(String name, String description, Room roomToUnlock) {
		super(name, description);
		this.roomToUnlock = roomToUnlock;
	}
	
	public void unlock(Room room) {
		room.setLocked(false);
	}
}
