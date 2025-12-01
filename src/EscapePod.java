
import java.util.ArrayList;

/**
 * Allows the Escape Pod to be its own class so rooms can be differentiated by type.
 * 
 * @author cdeluca
 */
public class EscapePod extends Room {
	
	/**
	 * 
	 * @param name The Escape Pod's technical name (e.g. Escape Pod 1, Escape Pod 2, etc).
	 * @param description The description the user will read of the room.
	 * @param entity The enemy the user fights (set to null for none).
	 * @param items The items in the room.
	 * @param isLocked Whether the room has been unlocked or not.
	 */
	public EscapePod(String name, String description, Entity entity, ArrayList<Item> items, boolean isLocked) {
		super(name, description, entity, items, isLocked);
	}

}
