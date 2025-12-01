
import java.util.Random;

/**
 * An item that can be used to defend the player.
 * @author cdeluca
 */
public class WeaponItem extends Item {
	private int damage;
	private Random random = new Random();
	
	/**
	 * 
	 * @param name The item's name.
	 * @param description The item's description.
	 * @param healingAmount The amount of damage to hit the enemy with.
	 */
	public WeaponItem(String name, String description, int damage) {
		super(name, description);
		this.damage = damage;
	}

	public int getDamage() {
		return random.nextInt((damage+5)-(damage-5)+1)+(damage-5);
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}
