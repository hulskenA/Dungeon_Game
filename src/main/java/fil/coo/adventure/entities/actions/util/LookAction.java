package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.PrintLookable;

public class LookAction implements Action {
	
	public boolean canBeDoneIn(Room r) {
		return true;
	}
	
	public void doneByIn(Player p, Room r) {
		System.out.println(p.description());
		System.out.println("\nRoom's description :");
		PrintLookable.printList("Monsters", r.getCharacters());
		PrintLookable.printList("Items", r.getItems());
		PrintLookable.printList("Dead", r.getDeads());
		/*PrintLookable.printList("Directions", r.getPossibleDirections());*/
	}
	
	public String toString() {
		return "Look around";
	}
}