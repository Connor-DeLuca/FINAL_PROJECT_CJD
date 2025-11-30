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

}
