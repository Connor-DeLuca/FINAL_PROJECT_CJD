

/**
 * The manager that handles rooms and how they connect.
 * 
 * @author cdeluca
 */
public class RoomManager {
    private Room[] rooms;
    private Room currentRoom;
    
    /**
     * 
     * @param rooms The list of rooms to walk through in order.
     */
    public RoomManager(Room[] rooms) {
    	this.rooms = rooms;
    	currentRoom = rooms[0];
    }
    
    /**
     * Moves the player to a specific room.
     * 
     * @param room
     */
    public void movePlayer(Room room) {
    	currentRoom = room;
    }
    
    public Room getRoomByIndex(int index) {
    	return rooms[index];
    }

	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
    
	/**
	 * Finds the next room in rooms.
	 * 
	 * @return The room after the current room.
	 */
    public Room getNextRoom() {
    	for (int i = 0; i < rooms.length; i++) {
    		if (rooms[i] == currentRoom) {
    			return rooms[i+1];
    		}
    	}
    	return null;
    }

}
