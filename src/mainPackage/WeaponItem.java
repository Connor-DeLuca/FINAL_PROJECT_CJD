package mainPackage;

public class WeaponItem extends Item {
	private int damage;
	
	public WeaponItem(String name, String description, int damage) {
		super(name, description);
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}
