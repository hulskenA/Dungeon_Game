package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.Player;

public class GoldChest extends Item {
	
	private final static int gold = 100;

	@Override
	public void isUsedBy(Player player) {
		player.addGold(gold);
		this.currentRoom().removeItem(this);
	}
	
	public String toString() {
		return "GoldChest : "+gold+" gold coins";
	}

	@Override
	public String description() {
		return "Gold chest\n\t> un coffre qui déborde de pièces d'or";
	}
	
}
