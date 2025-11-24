import java.util.Scanner;
package mainPackage;

public class Game {
	private RoomManager roomManager;
	Scanner scnr = new Scanner(System.in);
	String currentInput;
	String[] currentInputList;
	
	public Game() {
		// Instantiate room objects
		LivingQuarters livingQuarters = new LivingQuarters();
		Armory armory = new Armory();
		ControlRoom controlRoom = new ControlRoom();
		EscapePod escapePod = new EscapePod();
		Room[] rooms = {livingQuarters,armory,controlRoom,escapePod};
		roomManager = new RoomManager(rooms);
	}

	public void start() {
		String name = "Connor"; //CHANGE THIS LATER TO BE FROM INPUT
		// Explain how to play and what to do and the backstory
		Player player = new Player(this,name);
		
		/* Print out list of options and ask what to do.
		RoomManager needs to have a list of available
		unlocked Rooms, all the Room classes need to have list
		of available actions, enemies, etc. Also print the description
		of what's in the current room. Make options of what room to enter
		be numbers. Like Armory is 1, LivingQuarters is 2, etc. Don't start at 0
		because that would just be your current room.
		*/
		readInput();
	}
	
	public void endGame(boolean victory) {
		if (victory) {
			// the player won so wrap everything up
		}
		else {
			/* the player died (not sure how because the game is super easy, they must be really bad),
			 * so end the game
			 */
		}
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

	public String[] cleanInput(String input) {
		// change to lowercase, split to a list, ensure it's valid input, etc
		return input.split(" "); // for now
	}
	
	public void readInput() {
		currentInput = scnr.nextLine();
		currentInputList = cleanInput(currentInput);
		if(currentInputList[0].equals("enter")) {
			int roomIndex = Integer.parseInt(currentInputList[1]);
			roomManager.movePlayer(roomManager.getRoomByIndex(roomIndex));
		}
	}

	public RoomManager getRoomManager() {
		return roomManager;
	}

	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}
}
