package mainPackage;

/**
 * An enemy for the player to fight upon entering the room it is in.
 * 
 * @author cdeluca
 */
public class Entity {
	private String name;
	private String description;
	private int health;
	private boolean alive;
	private int damage;
	
	/**
	 * 
	 * @param name The entity's name.
	 * @param description The entity's description to be read to the player.
	 * @param health The entity's health (typically 100).
	 * @param damage The entity's damage to do to the player.
	 */
	public Entity(String name, String description, int health, int damage) {
		this.name = name;
		this.description = description;
		this.health = health;
		this.damage = damage;
		alive = true;
	}
	
	/**
	 * Removes damage from the player's health.
	 * 
	 * @param target
	 */
	public void attack(Player target) {
		target.setHealth(target.getHealth() - damage);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
}
