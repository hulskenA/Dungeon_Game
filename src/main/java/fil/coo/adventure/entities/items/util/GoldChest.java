package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.Player;

public class GoldChest extends Item {
	
	protected int gold = 100;

	@Override
	public void isUsedBy(Player player) {
		player.addGold(this.gold);
		this.currentRoom().removeItem(this);
		System.out.println("\t> You win "+this.gold+" gold coins");
	}

	public String name() {
		return "GoldChest";
	}

	public String toString() {
		return this.name()+" : "+this.gold+" gold coins";
	}

	@Override
	public String description() {
		return "Gold chest\n\t[un coffre qui déborde de pièces d'or]";
	}
	
}
