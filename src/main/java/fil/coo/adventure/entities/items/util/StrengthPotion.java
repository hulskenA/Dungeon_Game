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
		System.out.println("\t> "+AdventureGame.translator.translate("YouWin")+" "+st+" "+AdventureGame.translator.translate("StrengthPoints"));
	}
	
	public String toString() {
		return AdventureGame.translator.translate("StrengthPotion")+" : "+st+" "+AdventureGame.translator.translate("SP");
	}

	@Override
	public String description() {
		return AdventureGame.translator.translate("StrengthPotion")+" \n\t["+AdventureGame.translator.translate("StrengthPotionDescription")+"]";
	}

}
