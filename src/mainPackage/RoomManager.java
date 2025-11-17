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
    
    public void getRoom(String name) {
    	// search for a room with that name in rooms and return it
    }

}
