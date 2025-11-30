package mainPackage;
import java.util.Random;

public class Player {
	private String name;
	private int health;
	private Inventory inventory;
	private Game gameManager;
	private Random random = new Random();
	
	public Player(Game gameManager, String name) {
		this.gameManager = gameManager;
		this.name = name;
		health = 100;
		inventory = new Inventory();
	}
	
	public void pickUp(Item item) {
		inventory.add(item);
		gameManager.print("You found " + item.getName() + "!");
		gameManager.print(item.getDescription());
	}
	
	public void use(String name) {
		Item item = inventory.getItemByName(name);
		if (item instanceof ConsumableItem) {
			ConsumableItem healingItem = (ConsumableItem) item;
			healingItem.useConsumable(this);
			inventory.remove(healingItem);
			gameManager.print(item.getName() + " used.");
			gameManager.print("You now have " + health + "% health.");
			gameManager.newPrompt();
		}
		else {
			gameManager.print(item.getName() + " cannot be used. The use action is for consumables.");
			gameManager.print("If it is a weapon, it will automatically be used when you begin a fight.");
			gameManager.print("If it is a key, try to enter the next room.");
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Game getGameManager() {
		return gameManager;
	}

	public void setGameManager(Game gameManager) {
		this.gameManager = gameManager;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public void attack(Entity target) {
		// loop through and find the best weapon in the player's inventory
		int topDamage = 0;
		WeaponItem bestWeapon = null;
		for(int i = 0; i < inventory.getLength(); i++) {
			Item item = inventory.getItemByIndex(i);
			if (item instanceof WeaponItem) {
				WeaponItem currentWeapon = (WeaponItem) item;
				if (currentWeapon.getDamage() > topDamage) {
					bestWeapon = currentWeapon;
					topDamage = currentWeapon.getDamage();
				}
			}
		}
		/* Loop through and attack target with the player's best weapon. 
		 * Also handles logic for making target fight back and the player die if
		 * their health is 0.
		 */
		while (target.isAlive() && health > 0) {
			if (bestWeapon == null) {
				gameManager.print("You do not have any weapons to fight " + target.getName() + " with.");
				gameManager.print("You attempt to use your fists and do around 15-25 damage.");
				target.setHealth(target.getHealth() - (random.nextInt(25 - 15 + 1) + 15));
				if (target.getHealth() <= 0) {
					target.setAlive(false);
					break;
				}
				// CITE THIS
				target.attack(this);
				gameManager.print(target.getName() + " attacked you and did " + target.getDamage() + " damage.");
				gameManager.print("You have " + health + "% health left.");
			}
			else {
				target.setHealth(target.getHealth() - topDamage);
				gameManager.print("You attacked " + target.getName() + " with a(n) " + bestWeapon.getName());
				if (target.getHealth() <= 0) {
					target.setAlive(false);
					break;
				}
				target.attack(this);
				gameManager.print(target.getName() + " attacked you and did " + target.getDamage() + " damage.");
				gameManager.print("You have " + health + "% health left.");
			}
		}
		if (health <= 0) {
			gameManager.print("You were killed by " + target.getName() + ".");
			gameManager.endGame(false);
		}
		if (target.isAlive() == false) {
			gameManager.print("You took out " + target.getName() + "!");
		}
		
	}
}
