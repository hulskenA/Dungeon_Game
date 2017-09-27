package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class LifePotion extends Item {
	
	private final static int lp = 30;

	@Override
	public void isUsedBy(Player player) {
		player.loseLife(-lp);
		this.currentRoom().removeItem(this);
	}
	
	public String toString() {
		return "LifePotion : +"+lp+" LP";
	}

}
