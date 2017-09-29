package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class StrengthPotion extends Item {
	
	protected int st = 15;

	@Override
	public void isUsedBy(Player player) {
		player.addStrength(st);
		this.currentRoom().removeItem(this);
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("YouWin")+st+" "+AdventureGame.TRANSLATOR.translate("StrengthPoints"));
	}
	
	public String toString() {
		return AdventureGame.TRANSLATOR.translate("StrengthPotion")+" : "+st+" "+AdventureGame.TRANSLATOR.translate("SP");
	}

	@Override
	public String description() {
		return AdventureGame.TRANSLATOR.translate("StrengthPotion")+" \n\t["+AdventureGame.TRANSLATOR.translate("StrengthPotionDescription")+"]";
	}

}
