

/**
 * An item that can be used to open a door.
 * 
 * @author cdeluca
 */
public class KeyItem extends Item {
	
	/**
	 * 
	 * @param name The item's unique name.
	 * @param description The item's description to be read by the user.
	 */
	public KeyItem(String name, String description) {
		super(name, description);
	}
	
	/**
	 * Unlocks a room so it can be entered by the player.
	 * 
	 * @param room The room to unlock.
	 */
	public void unlock(Room room) {
		room.setLocked(false);
	}
	
}
