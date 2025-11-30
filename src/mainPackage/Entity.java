package mainPackage;

public class Entity {
	private String name;
	private String description;
	private int health;
	private boolean alive;
	
	public Entity(String name, String description, int health) {
		this.name = name;
		this.description = description;
		this.health = health;
		alive = true;
	}
	
	public void attack(int damage, Player target) {
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
}
