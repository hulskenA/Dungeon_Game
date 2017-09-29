package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class LifePotion extends Item {
	
	private final static int lp = 50;

	@Override
	public void isUsedBy(Player player) {
		player.loseLife(-lp);
		this.currentRoom().removeItem(this);
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("YouWin")+lp+" "+AdventureGame.TRANSLATOR.translate("LifePoints"));
	}
	
	public String toString() {
		return AdventureGame.TRANSLATOR.translate("LifePotion")+" : "+lp+" "+AdventureGame.TRANSLATOR.translate("LP");
	}

	@Override
	public String description() {
		return AdventureGame.TRANSLATOR.translate("LifePotion")+"\n\t["+AdventureGame.TRANSLATOR.translate("LifePotionDescription")+"]";
	}

}
