package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.monsters.util.BadChest;

public class SleepedBadChest extends Item {

	@Override
	public void isUsedBy(Player player) {
		this.currentRoom().addCharacter(new BadChest());
		this.currentRoom().removeItem(this);
		System.out.println("\t> Oh non c'était un coffre piégé et tu viens de le réveiller");
	}
	
	public String toString() {
		return "GoldChest : "+GoldChest.gold+" gold coins";
	}

	@Override
	public String description() {
		return "Gold chest\n\t[un coffre qui déborde de pièces d'or]";
	}

}
