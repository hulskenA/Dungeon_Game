package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the strength potion item. This item gives 
 * exactly 15 strength points to the player when used.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class StrengthPotion implements Item {
	
	protected int st = 15;

	/**
	 * See Item interface documentation
	 */
	public void isUsedBy(Player player) {
		player.addStrength(st);
		player.currentRoom().removeItem(this);
		System.out.println("\t> "+Translator.translate("YouWin")+" "+st+" "+Translator.translate("StrengthPoints"));
	}
	
	public String toString() {
		return Translator.translate("StrengthPotion")+" : "+st+" "+Translator.translate("SP");
	}

	public String description() {
		return Translator.translate("StrengthPotion")+" \n\t["+Translator.translate("StrengthPotionDescription")+"]";
	}

}
