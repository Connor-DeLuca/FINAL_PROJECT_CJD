import java.io.IOException;
import java.util.Scanner;

public class Game {
	private RoomManager roomManager;
	Scanner scnr = new Scanner(System.in);
	
	public Game() {
		roomManager = new RoomManager();
	}

	public void Start() {
		/* Print out list of options and ask what to do.
		RoomManager needs to have a list of available
		unlocked Rooms, all the Room classes meed to have list
		of available actions, enemies, etc. Also print the description
		of what's in the current room.
		*/
	}

	/*
	I may or may not end up using this method
	If not, I guess it'll just use up memory for
	no reason
	*/
	public static void clearConsole()
    {
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

	public void ProcessInput() {
		// change to lowercase, ensure it's valid input, etc
	}

	public RoomManager getRoomManager() {
		return roomManager;
	}

	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}
}
