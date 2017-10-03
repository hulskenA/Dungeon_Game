package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the life potion item. This item restores exactly
 * 50 life points when used by the player.
 * @author ubuntu
 *
 */
public class LifePotion implements Item {
	
	protected int lp = 50;

	/**
	 * See Item interface documentation
	 */
	public void isUsedBy(Player player) {
		player.loseLife(-this.lp);
		player.currentRoom().removeItem(this);
		System.out.println("\t> "+Translator.translate("YouWin")+" "+this.lp+" "+Translator.translate("LifePoints"));
	}
	
	public String toString() {
		return Translator.translate("LifePotion")+" : "+this.lp+" "+Translator.translate("LP");
	}

	public String description() {
		return Translator.translate("LifePotion")+"\n\t["+Translator.translate("LifePotionDescription")+"]";
	}

}
