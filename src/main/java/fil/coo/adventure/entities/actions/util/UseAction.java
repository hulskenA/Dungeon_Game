package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.ListChoser;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class defines the behavior for the Use Action :
 * Displays the list of items in the room (if any) allowing the player to
 * choose to use of them and then applies it's effect on the player.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class UseAction implements Action {

	/**
	 * See Action interface documentation
	 */
	public boolean canBeDoneIn(Room r) {
		/* There must be items in the room for the player to pick up. */
		return !r.getItems().isEmpty() && r.isDiscoverd();
	}

	/**
	 * See Action interface documentation
	 */
	public void doneBy(Player p) {
		/* We let the player choose will item he wants to use */
		Item i = ListChoser.chose(Translator.translate("UseAsk"), p.currentRoom().getItems());
		/* We use the item */
		if (i == null) {
			System.out.println("\t> "+Translator.translate("UseAborded"));
		}
		else {
			i.isUsedBy(p);
		}
	}


	public String toString() {
		return Translator.translate("Use");
	}
}
