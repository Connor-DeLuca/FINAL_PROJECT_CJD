package mainPackage;
import java.util.Random;

public class Player {
	private String name;
	private int health;
	private Inventory<Item> inventory;
	private Game gameManager;
	private Random random = new Random();
	
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
		Item item = inventory.getItemByName(name);
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
	
	public void attack(Entity target) {
		// loop through and find the best weapon in the player's inventory
		int topDamage = 0;
		WeaponItem weapon = null;
		for(int i = 0; i < inventory.getLength(); i++) {
			if (inventory.getItemByIndex(i) instanceof WeaponItem) {
				if (inventory.getItemByIndex(i).getDamage() > topDamage) {
					weapon = inventory.getItemByIndex(i);
					topDamage = weapon.getDamage();
				}
			}
		}
		/* Loop through and attack target with the player's best weapon. 
		 * Also handles logic for making target fight back and the player die if
		 * their health is 0.
		 */
		while (target.isAlive() && health > 0) {
			if (weapon == null) {
				gameManager.print("You do not have any weapons to fight " + target.getName() + " with.");
				gameManager.print("You attempt to use your fists and do around 15-25 damage.");
				target.setHealth(target.getHealth() - (random.nextInt(25 - 15 + 1) + 15));
				target.attack(20);
			}
			else {
				target.setHealth(target.getHealth() - topDamage);
				gameManager.print("You attacked " + target.getName() + " with a(n) " + weapon.getName());
				
			}
		}
		if (health <= 0) {
			gameManager.print("You were killed by " + entity.getName() + ".");
			gameManager.endGame(false);
		}
		if (target.isAlive() == false) {
			gameManager.print("You took out " + target.getName() + "!");
			gameManager.print("You may consider checking your inventory for healing items and using one if you have it.");
			gameManager.newPrompt();
		}
		
	}
}
