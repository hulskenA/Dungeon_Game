package fil.coo.adventure.entities.actions.util;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.places.Direction;
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
		List<Direction> directions = new ArrayList<Direction>(r.getPossibleDirections());
		PrintLookable.printList("Directions", directions);
	}
	
	public String toString() {
		return "Look around";
	}
}