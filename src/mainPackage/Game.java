import java.util.Scanner;
package mainPackage;

public class Game {
	private RoomManager roomManager;
	Scanner scnr = new Scanner(System.in);
	
	public Game() {
		roomManager = new RoomManager();
	}

	public void start() {
		/* Print out list of options and ask what to do.
		RoomManager needs to have a list of available
		unlocked Rooms, all the Room classes need to have list
		of available actions, enemies, etc. Also print the description
		of what's in the current room.
		*/
	}
	
	public void print(String output) {
		System.out.println(output); // change this if you decide to do a different output method
	}

	public void newPrompt() {
		// ask what the user wants to do
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

	public void processInput() {
		// change to lowercase, ensure it's valid input, etc
	}

	public RoomManager getRoomManager() {
		return roomManager;
	}

	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}
}
