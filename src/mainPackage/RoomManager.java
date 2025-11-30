package mainPackage;

public class RoomManager {

    private Room[] rooms;
    private Room currentRoom;
    
    public RoomManager(Room[] rooms) {
    	this.rooms = rooms;
    	currentRoom = rooms[0];
    }
    
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
    
    public Room getNextRoom() {
    	for (int i = 0; i < rooms.length; i++) {
    		if (rooms[i] == currentRoom) {
    			return rooms[i+1];
    		}
    	}
    	return null;
    }

}
