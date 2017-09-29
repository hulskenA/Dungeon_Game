package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class LifePotion extends Item {
	
	protected int lp = 50;

	@Override
	public void isUsedBy(Player player) {
		player.loseLife(-this.lp);
		this.currentRoom().removeItem(this);
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("YouWin")+this.lp+" "+AdventureGame.TRANSLATOR.translate("LifePoints"));
	}
	
	public String toString() {
		return AdventureGame.TRANSLATOR.translate("LifePotion")+" : "+this.lp+" "+AdventureGame.TRANSLATOR.translate("LP");
	}

	@Override
	public String description() {
		return AdventureGame.TRANSLATOR.translate("LifePotion")+"\n\t["+AdventureGame.TRANSLATOR.translate("LifePotionDescription")+"]";
	}

}
