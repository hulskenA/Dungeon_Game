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
		System.out.println("\t> "+AdventureGame.translator.translate("YouWin")+" "+this.lp+" "+AdventureGame.translator.translate("LifePoints"));
	}
	
	public String toString() {
		return AdventureGame.translator.translate("LifePotion")+" : "+this.lp+" "+AdventureGame.translator.translate("LP");
	}

	@Override
	public String description() {
		return AdventureGame.translator.translate("LifePotion")+"\n\t["+AdventureGame.translator.translate("LifePotionDescription")+"]";
	}

}
