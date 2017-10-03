package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.monsters.util.BadChest;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the sleeped bad chest item. This item is very special
 * type of gold chest, which is actually enchanted and when the player attempts
 * to pick it up, it will transform into a monster. So the player will then have
 * to kill the Monster BadChest in order to pick up the gold contained in the chest.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class SleepedBadChest extends GoldChest {

	/**
	 * See Item interface documentation
	 */
	public void isUsedBy(Player player) {
		player.currentRoom().addCharacter(new BadChest(25,5));
		player.currentRoom().removeItem(this);
		System.out.println("\t> "+Translator.translate("SleepedBadGoldChestEffect"));
	}
	
}
