package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;

public class LookAction implements Action {
	
	public boolean canBeDoneIn(Room r) {
		return true;
	}
	
	public void doneByIn(Player p, Room r) {
		System.out.println(this.toString());
	}
	
	public String toString() {
		return "Look around";
	}
}