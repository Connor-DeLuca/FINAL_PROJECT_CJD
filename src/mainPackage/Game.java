package mainPackage;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class Game {
	private RoomManager roomManager;
	private Player player;
	Scanner scnr = new Scanner(System.in);
	String currentInput;
	String[] currentInputList;
	
	public Game() {
		// Instantiate room objects
		
		ArrayList<Item> livingQuartersItems = new ArrayList<>();
		KeyItem armoryKey = new KeyItem("Armory Key","A key that appears to unlock the armory.");
		livingQuartersItems.add(armoryKey);
		String livingQuartersDesc = "Not much here. You see the beds, dressers (maybe something useful, maybe not), and the door.";
		LivingQuarters livingQuarters = new LivingQuarters("Living Quarters",livingQuartersDesc,null,livingQuartersItems,false);
		
		ArrayList<Item> armoryItems = new ArrayList<>();
		KeyItem controlRoomKey = new KeyItem("Control Room Key","A key that appears to unlock the Control Room.");
		WeaponItem golfClub = new WeaponItem("Golf Club","A rusty old club that's better than your fists.",25);
		armoryItems.add(golfClub);
		armoryItems.add(controlRoomKey);
		String armoryDesc = "Just your armory. There does appear to be one unlocked locker,\nand you also notice some boxes to the side.";
		Armory armory = new Armory("Armory",armoryDesc,null,armoryItems,false);
		
		ArrayList<Item> controlRoomItems = new ArrayList<>();
		KeyItem escapePodKey = new KeyItem("Escape Pod Key","A shiny golden key that appears to start the escape pods.");
		ConsumableItem medicine = new ConsumableItem("Sketchy Medical Pills","Pills in a label-less container that look dodgy, but probably heal you.",60);
		WeaponItem laserGun = new WeaponItem("Laser Gun","A nice weapon that may just save your life.",45);
		controlRoomItems.add(medicine);
		controlRoomItems.add(escapePodKey);
		controlRoomItems.add(laserGun);
		Entity angryRobot = new Entity("Angry Robot","A robot that may have once mopped your floors but has been hacked and is now ready to end you.",100,25);
		String controlRoomDesc = "Many buttons and switches that you wish you knew how to use. You just fly with autopilot.\nYou see the broken robot you ended, some medicine cabinets, and another weapon locker.";
		ControlRoom controlRoom = new ControlRoom("Control Room",controlRoomDesc,angryRobot,controlRoomItems,false);
		
		Entity bigAngryRobot = new Entity("Big Angry Robot","This is not going to be as easy as the last one...",100,40);
		EscapePod escapePod = new EscapePod("Escape Pod","",bigAngryRobot,null,false);
		
		Room[] rooms = {livingQuarters,armory,controlRoom,escapePod};
		roomManager = new RoomManager(rooms);
	}

	public void start() {
		String name = "Connor"; //CHANGE THIS LATER TO BE FROM INPUT
		// Explain how to play and what to do and the backstory
		player = new Player(this,name);
		
		System.out.println("Systems Initializing...");
		System.out.println("You are an astronaut stranded deep in space.");
		System.out.println("Someone has remotely hacked your ship and the power is out.");
		System.out.println("You must make it to the escape pod before the rogue robots on your ship end you.");
		System.out.println("You will be able to interact with the story using many choices throughout.");
		
		/* Print out list of options and ask what to do.
		RoomManager needs to have a list of available
		unlocked Rooms, all the Room classes need to have list
		of available actions, enemies, etc. Also print the description
		of what's in the current room. Make options of what room to enter
		be numbers. Like Armory is 1, LivingQuarters is 2, etc. Don't start at 0
		because that would just be your current room.
		*/
		while (true) {
			Room current = roomManager.getCurrentRoom();
			if (current.getEntity() != null) {
				player.attack(current.getEntity());
				roomManager.getCurrentRoom().setEntity(null);
			}
			if (current instanceof EscapePod) {
				endGame(true);
			}
			newPrompt();
		}
	}
	
	public void endGame(boolean victory) {
		if (victory) {
			System.out.println("You made it to the escape pods alive!");
			System.out.println("You enter the escape pod and shoot off towards the nearest planet.");
			System.out.println("Congratulations, you win!");
			System.exit(0);
		}
		else {
			/* the player died (not sure how because the game is super easy, they must be really bad),
			 * so end the game
			 */
			System.out.println("You have died, and thus your story ends here. Nice try!");
			System.exit(0);
		}
	}
	
	public void print(String output) {
		System.out.println(output); // change this if you decide to do a different output method
	}

	public void newPrompt() {
		Room current = roomManager.getCurrentRoom();
		
		System.out.println("You are in " + current.getName());
		System.out.println(current.getDescription());
		System.out.println("What would you like to do?");
		System.out.println("1: Enter the next room (if you have the key)");
		System.out.println("2: Look for items");
		System.out.println("3: Use an item like a consumable");
		
		int choice = promptMenuChoice("Choose an option.",1,3);
		
		if (choice == 1) {
			String nextKey = roomManager.getNextRoom().getName() + " Key";
			if (player.getInventory().getItemByName(nextKey) != null) {
				System.out.println("You have entered the next room.");
				roomManager.movePlayer(roomManager.getNextRoom());
			}
			else {
				System.out.println("You wiggle the doorknob but it is locked. There must be a manual key stored somewhere...");
			}
		}
		else if (choice == 2) {
			searchRoom();
		}
		else {
			if (player.getInventory().getLength() == 0) {
				System.out.println("Your inventory is empty.");
			}
			else {
				showInventory();
				System.out.println("Type the number of the item to use (Or 0 to cancel): ");
				int useIndex = promptMenuChoice("",0,player.getInventory().getLength());
				if (useIndex == 0) {
					System.out.println("Cancelled.");
				}
				else {
					Item itemToUse = player.getInventory().getItemByIndex(useIndex-1);
					if (itemToUse == null) {
						System.out.println("Invalid Item.");
					}
					else {
						player.use(itemToUse.getName());
					}
				}
			}
		}
	}
	
	public void showInventory() {
		Inventory inv = player.getInventory();
		System.out.println("\nInventory:");
		for(int i = 0; i < inv.getLength(); i++) {
			Item item = inv.getItemByIndex(i);
			System.out.println((i + 1) + ": " + item.getName());
		}
	}
	
	public void searchRoom() {
		Room current = roomManager.getCurrentRoom();
		ArrayList<Item> items = current.getItems();
		if (items.isEmpty()) {
			System.out.println("Looks like that's all the items in here.");
		}
		else {
			Item found = items.get(0);
			player.pickUp(found);
			current.removeItem(found);
		}
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

	public int promptMenuChoice(String message, int min, int max) {
		while (true) {
			System.out.println(message);
			String input = scnr.nextLine().trim();
			try {
				int choice = Integer.parseInt(input.trim());
				if (choice >= min && choice <= max) {
					return choice;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Not a valid choice. Please try again.");
			}
		}
	}


	public RoomManager getRoomManager() {
		return roomManager;
	}

	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}
}
