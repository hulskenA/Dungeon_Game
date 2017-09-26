package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;

public class UseAction implements Action {

	public boolean canBeDoneIn(Room r) {
		/* There must be items in the room for the player to pick up. */
		return !r.getItems().isEmpty();
	}

	public void doneByIn(Player p, Room r) {
		// To be defined
	}
	

	public String toString() {
		return "Pick up and use an item";
	}
}
