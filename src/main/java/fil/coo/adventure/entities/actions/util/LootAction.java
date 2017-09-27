package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;

// BONUS, WILL BE DONE IN THE FUTURE
public class LootAction implements Action  {

	public boolean canBeDoneIn(Room r) {
		return !r.getDeads().isEmpty();
	}

	public void doneByIn(Player p, Room r) {
		for (GameCharacters gc : r.getDeads())
			p.addGold(gc.getGold());
		r.getDeads().removeAll(r.getDeads());
	}

	public String toString() {
		return "Loot a corpse";
	}
}