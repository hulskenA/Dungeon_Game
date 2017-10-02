package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;

public class GoldChest extends Item {

	protected int gold;

	public GoldChest() {
		this.gold=100;
	}

	@Override
	public void isUsedBy(Player player) {
		player.addGold(this.gold);
		this.currentRoom().removeItem(this);
		System.out.println("\t> "+AdventureGame.translator.translate("YouWin")+" "+this.gold+" "+AdventureGame.translator.translate("GoldCoins"));
	}

	public String name() {
		return AdventureGame.translator.translate("GoldChest");
	}

	public String toString() {
		return this.name()+" : "+this.gold+" "+AdventureGame.translator.translate("GoldCoins");
	}

	@Override
	public String description() {
		return AdventureGame.translator.translate("GoldChest")+"\n\t["+AdventureGame.translator.translate("GoldChestDescription")+"]";
	}

}
