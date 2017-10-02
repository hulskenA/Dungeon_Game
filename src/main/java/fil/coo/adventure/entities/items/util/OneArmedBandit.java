package fil.coo.adventure.entities.items.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class OneArmedBandit extends Item {

	protected int price = 100;
	private static final List<Item> POSSIBLES = new ArrayList<Item>(); {{
		POSSIBLES.add(new GoldChest());
		POSSIBLES.add(new SleepedBadChest());
		POSSIBLES.add(new LifePotion());
		POSSIBLES.add(new StrengthPotion());
	}}

	@Override
	public void isUsedBy(Player player) {
		if (player.getGold() < price)
			System.out.println("\t> "+AdventureGame.translator.translate("OneArmedBanditDontUsable1")+(price-player.getGold())+AdventureGame.translator.translate("OneArmedBanditDontUsable2"));
		else {
			Random r = new Random();
			int index = r.nextInt(POSSIBLES.size());
			Item item = POSSIBLES.get(index);
			this.currentRoom().addItem(item);
			this.currentRoom().removeItem(this);
			System.out.println("\t> "+AdventureGame.translator.translate("OneArmedBanditEffect")+" "+item.toString());
		}
	}

	public String toString() {
		return AdventureGame.translator.translate("OneArmedBandit")+" : "+price+AdventureGame.translator.translate("OneArmedBanditCost");
	}

	@Override
	public String description() {
		return AdventureGame.translator.translate("OneArmedBandit")+"\n\t[\""+AdventureGame.translator.translate("OneArmedBanditDescription")+"\"]";
	}

}
