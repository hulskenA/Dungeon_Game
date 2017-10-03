package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.Player;

/**
 * The gold chest class describes an item that is a chest filled with exactly
 * 100 gold coins, that obtained by the player when he uses it.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class GoldChest implements Item {

	protected int gold;

	public GoldChest() {
		this.gold=100;
	}

	/**
	 * See Item interface documentation
	 */
	public void isUsedBy(Player player) {
		player.addGold(this.gold);
		player.currentRoom().removeItem(this);
		System.out.println("\t> "+Translator.translate("YouWin")+" "+this.gold+" "+Translator.translate("GoldCoins"));
	}

	public String name() {
		return Translator.translate("GoldChest");
	}

	public String toString() {
		return this.name()+" : "+this.gold+" "+Translator.translate("GoldCoins");
	}

	public String description() {
		return Translator.translate("GoldChest")+"\n\t["+Translator.translate("GoldChestDescription")+"]";
	}

}
