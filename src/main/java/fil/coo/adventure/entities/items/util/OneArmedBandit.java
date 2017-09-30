package fil.coo.adventure.entities.items.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class OneArmedBandit extends Item {
	
	protected int price = 100;
	private static final List<Item> possible = new ArrayList<Item>(); {{
		possible.add(new GoldChest());
		possible.add(new LifePotion());
		possible.add(new StrengthPotion());
	}}
	
	@Override
	public void isUsedBy(Player player) {
		if (player.getGold() < price)
			System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("OneArmedBanditDontUsable1")+(price-player.getGold())+AdventureGame.TRANSLATOR.translate("OneArmedBanditDontUsable2"));
		else {
			Random r = new Random();
			int index = r.nextInt(possible.size());
			Item item = possible.get(index);
			this.currentRoom().addItem(item);
			this.currentRoom().removeItem(this);
			System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("OneArmedBanditEffect")+" "+item.toString());
		}
	}
	
	public String toString() {
		return AdventureGame.TRANSLATOR.translate("OneArmedBandit")+" : "+price+AdventureGame.TRANSLATOR.translate("OneArmedBanditCost");
	}

	@Override
	public String description() {
		return AdventureGame.TRANSLATOR.translate("OneArmedBandit")+"\n\t[\""+AdventureGame.TRANSLATOR.translate("OneArmedBanditDescription")+"\"]";
	}	

}
