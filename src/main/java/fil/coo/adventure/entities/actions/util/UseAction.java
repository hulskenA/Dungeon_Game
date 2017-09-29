package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.ListChoser;

public class UseAction implements Action {

	public boolean canBeDoneIn(Room r) {
		/* There must be items in the room for the player to pick up. */
		return !r.getItems().isEmpty() && r.isDiscoverd();
	}

	public void doneByIn(Player p, Room r) {
		/* We let the player choose will item he wants to use */
		Item i = ListChoser.chose(AdventureGame.TRANSLATOR.translate("UesAsk"), r.getItems());
		/* We use the item */
		if (i == null) {
			System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("UseAborded"));
		}
		else {
			i.isUsedBy(p);
		}
	}


	public String toString() {
		return AdventureGame.TRANSLATOR.translate("Use");
	}
}
