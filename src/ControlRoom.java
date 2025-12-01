
import java.util.ArrayList;

/**
 * Allows the ControlRoom to be its own class so rooms can be differentiated by type.
 * 
 * @author cdeluca
 */
public class ControlRoom extends Room {
	
	/**
	 * 
	 * @param name The Control Room's technical name (e.g. Control Room 1, Control Room 2, etc).
	 * @param description The description the user will read of the room.
	 * @param entity The enemy the user fights (set to null for none).
	 * @param items The items in the room.
	 * @param isLocked Whether the room has been unlocked or not.
	 */
	public ControlRoom(String name, String description, Entity entity, ArrayList<Item> items, boolean isLocked) {
		super(name, description, entity, items, isLocked);
	}

}
