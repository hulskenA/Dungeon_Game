package fil.coo.adventure.entities.items.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class OneArmedBandit extends Item {
	
	private final static int price = 100;
	private final List<Item> possible = new ArrayList<Item>();

	public OneArmedBandit() {
		possible.add(new GoldChest());
		possible.add(new LifePotion());
		possible.add(new StrengthPotion());
	}
	
	@Override
	public void isUsedBy(Player player) {
		if (player.getGold() < price)
			System.out.println("\t> You must have more "+(price-player.getGold())+" gold coins for use it!");
		else {
			Random r = new Random();
			int index = r.nextInt(possible.size());
			Item item = this.possible.get(index);
			this.currentRoom().addItem(item);
			this.currentRoom().removeItem(this);
			System.out.println("\t> You win "+item.toString());
		}
	}
	
	public String toString() {
		return "OneArmeBandit : "+price+" cost";
	}

}
