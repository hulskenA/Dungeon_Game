package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;

public class GoldChest extends Item {
	
	protected int gold = 100;

	@Override
	public void isUsedBy(Player player) {
		player.addGold(this.gold);
		this.currentRoom().removeItem(this);
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("YouWin")+this.gold+" gold coins");
	}

	public String name() {
		return AdventureGame.TRANSLATOR.translate("GoldChest");
	}

	public String toString() {
		return this.name()+" : "+this.gold+AdventureGame.TRANSLATOR.translate("GoldCoins");
	}

	@Override
	public String description() {
		return AdventureGame.TRANSLATOR.translate("GoldChest")+"\n\t["+AdventureGame.TRANSLATOR.translate("GoldChestDescription")+"]";
	}
	
}
