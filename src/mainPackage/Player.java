package mainPackage;

public class Player {
	private String name;
	private int health;
	private Inventory<Item> inventory;
	private Game gameManager;
	
	public Player(Game gameManager, String name) {
		this.gameManager = gameManager;
		this.name = name;
		health = 0;
		inventory = new Inventory<Item>(); //come back here after you finished Inventory to make sure this is how you declare it
	}
	
	public void pickUp(Item item) {
		inventory.add(item);
		gameManager.print(item.getName() + " picked up.");
		gameManager.newPrompt();
	}
	
	public void use(String name) {
		Item item = inventory.getItem(name);
		if (item instanceof ConsumableItem) {
			item.useConsumable();
			inventory.remove(name);
			gameManager.print(item.getName() + " used.");
			gameManager.newPrompt();
		}
		else {
			gameManager.print(item.getName() + " cannot be used. \"use\" is for consumables.");
			gameManager.print("If it is a weapon, type attack <EnemyName> and your best weapon will be used.");
			gameManager.print("If it is a key, type unlock <RoomName>.");
			gameManager.newPrompt();
		}
	}
	
	// make attack
}
