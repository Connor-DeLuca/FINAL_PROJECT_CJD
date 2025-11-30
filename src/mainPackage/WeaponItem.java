package mainPackage;
import java.util.Random;

public class WeaponItem extends Item {
	private int damage;
	private Random random = new Random();
	
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
