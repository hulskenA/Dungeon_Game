package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class StrengthPotion extends Item {
	
	private final static int st = 15;

	@Override
	public void isUsedBy(Player player) {
		player.addStrength(st);
		this.currentRoom().removeItem(this);
	}
	
	public String toString() {
		return "StrengthPotion : "+st+" SP";
	}

}
