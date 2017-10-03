package fil.coo.adventure.entities.items.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the one-armed bandit item. This item spits out a random
 * item from those contained in its POSSIBLES (List<Item>) list of items. The one-
 * armed bandit drops the item on the ground of the room in which it is used. It 
 * also requires the user to have at least 100 gold in order to use. 
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class OneArmedBandit implements Item {

	protected int price = 100;
	private static final List<Item> POSSIBLES = new ArrayList<Item>(); {{
		POSSIBLES.add(new GoldChest());
		POSSIBLES.add(new SleepedBadChest());
		POSSIBLES.add(new LifePotion());
		POSSIBLES.add(new StrengthPotion());
	}}

	/**
	 * See Item interface documentation
	 */
	public void isUsedBy(Player player) {
		if (player.getGold() < price)
			System.out.println("\t> "+Translator.translate("OneArmedBanditDontUsable1")+(price-player.getGold())+Translator.translate("OneArmedBanditDontUsable2"));
		else {
			Random r = new Random();
			int index = r.nextInt(POSSIBLES.size());
			Item item = POSSIBLES.get(index);
			player.currentRoom().addItem(item);
			player.addGold(-100);
			player.currentRoom().removeItem(this);
			System.out.println("\t> "+Translator.translate("OneArmedBanditEffect")+" "+item.toString());
		}
	}

	public String toString() {
		return Translator.translate("OneArmedBandit")+" : "+price+Translator.translate("OneArmedBanditCost");
	}
	
	public String description() {
		return Translator.translate("OneArmedBandit")+"\n\t[\""+Translator.translate("OneArmedBanditDescription")+"\"]";
	}

}
