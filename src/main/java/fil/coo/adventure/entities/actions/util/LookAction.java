package fil.coo.adventure.entities.actions.util;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.places.Direction;
import fil.coo.adventure.util.PrintLookable;

/**
 * This class defines the behavior for the Look Action:
 * This uses the Lookable interface in order to display relevant
 * information for each object in the room tha the action is used. 
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class LookAction implements Action {

	/**
	 * See Action interface documentation.
	 */
	public boolean canBeDoneIn(Room r) {
		return true;
	}

	/**
	 * See Action interface documentation.
	 */
	public void doneBy(Player p) {
		p.currentRoom().discovered();
		System.out.println(p.description());
		System.out.println("\n"+Translator.translate("LookRoom")+" :");
		PrintLookable.printList(Translator.translate("Monsters"), p.currentRoom().getCharacters());
		PrintLookable.printList(Translator.translate("Items"), p.currentRoom().getItems());
		PrintLookable.printList(Translator.translate("Dead"), p.currentRoom().getDeads());
		List<Direction> directions = new ArrayList<Direction>(p.currentRoom().getPossibleDirections());
		PrintLookable.printList(Translator.translate("Directions"), directions);
	}

	public String toString() {
		return Translator.translate("Look");
	}
}
