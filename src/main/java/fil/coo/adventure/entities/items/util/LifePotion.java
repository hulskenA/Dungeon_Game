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
		return "LifePotion : "+lp+" LP";
	}

	@Override
	public String description() {
		return "Life potion\n\t> une grande marmitte rose qui fait des bulles et avec le coeur d'un zombi dedans *Beurk*";
	}

}
