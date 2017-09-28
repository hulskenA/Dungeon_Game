package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class StrengthPotion extends Item {
	
	private final static int st = 15;

	@Override
	public void isUsedBy(Player player) {
		player.addStrength(st);
		this.currentRoom().removeItem(this);
		System.out.println("\t> You win "+st+"Strength points");
	}
	
	public String toString() {
		return "StrengthPotion : "+st+" SP";
	}

	@Override
	public String description() {
		return "Strength potion \n\t[C'est une petite fiole bleu de forme cônique avec une tête de mort dessus]";
	}

}
