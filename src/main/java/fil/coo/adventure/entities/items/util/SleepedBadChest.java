package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.monsters.util.BadChest;

public class SleepedBadChest extends GoldChest {

	public void isUsedBy(Player player) {
		this.currentRoom().addCharacter(new BadChest());
		this.currentRoom().removeItem(this);
		System.out.println("\t> "+AdventureGame.translator.translate("SleepedBadGoldChestEffect"));
	}
	
}
