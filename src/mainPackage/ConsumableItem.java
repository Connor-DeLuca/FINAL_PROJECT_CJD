package mainPackage;

public class ConsumableItem extends Item {
	private int healingAmount;
	
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
	
	public void useConsumable(Player player) {
		if(player.getHealth() + healingAmount > 100) {
			player.setHealth(player.getHealth() + healingAmount);
		}
		else {
			player.setHealth(100);
		}
	}
}
