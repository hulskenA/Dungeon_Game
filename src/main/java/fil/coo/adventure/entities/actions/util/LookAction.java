package fil.coo.adventure.entities.actions.util;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.AdventureGame;
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
		r.discovered();
		System.out.println(p.description());
		System.out.println("\n"+AdventureGame.TRANSLATOR.translate("LookRoom")+" :\n\t["+r.description()+"]");
		PrintLookable.printList(AdventureGame.TRANSLATOR.translate("Monsters"), r.getCharacters());
		PrintLookable.printList(AdventureGame.TRANSLATOR.translate("Items"), r.getItems());
		PrintLookable.printList(AdventureGame.TRANSLATOR.translate("Dead"), r.getDeads());
		List<Direction> directions = new ArrayList<Direction>(r.getPossibleDirections());
		PrintLookable.printList(AdventureGame.TRANSLATOR.translate("Directions"), directions);
	}
	
	public String toString() {
		return AdventureGame.TRANSLATOR.translate("Look");
	}
}