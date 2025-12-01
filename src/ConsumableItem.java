

/**
 * An item that can be used to heal the player.
 * @author cdeluca
 */
public class ConsumableItem extends Item {
	private int healingAmount;
	
	/**
	 * 
	 * @param name The item's name.
	 * @param description The item's description.
	 * @param healingAmount The amount of health to heal the player.
	 */
	public ConsumableItem(String name, String description, int healingAmount) {
		super(name, description);
		this.healingAmount = healingAmount;
	}
	
	public int getHealingAmount() {
		return healingAmount;
	}

	public void setHealingAmount(int healingAmount) {
		this.healingAmount = healingAmount;
	}
	
	/**
	 * Heals the selected player.
	 * 
	 * @param player The player to heal.
	 */
	public void useConsumable(Player player) {
		if(player.getHealth() + healingAmount > 100) {
			player.setHealth(player.getHealth() + healingAmount);
		}
		else {
			player.setHealth(100);
		}
	}
}
