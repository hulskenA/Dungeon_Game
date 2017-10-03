package fil.coo.adventure.entities.actions.util;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Direction;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.ListChoser;

/**
 * This class defines the behavior of the Move Action :
 * Display a list of directions to the player, allowing him to chose one,
 * then moves in that direction. This action is only possible if there are
 * no monsters in the room.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class MoveAction implements Action {

	/**
	 * See Action interface documentation
	 */
	public boolean canBeDoneIn(Room r) {
		/* A player can move if there aren't any live monsters in the room */
		return r.getCharacters().isEmpty() && r.isDiscoverd();
	}

	/**
	 * See Action interface documentation
	 */
	public void doneBy(Player p) {
		List<Direction> directions = new ArrayList<Direction>();
		directions.addAll(p.currentRoom().getPossibleDirections());
		Direction d = ListChoser.chose(Translator.translate("MoveAsk"),directions);
		if (d == null) {
			System.out.println("\t> "+Translator.translate("MoveRest"));
		} else {
			System.out.println("\t> "+Translator.translate("MoveNextRoom"));
			p.moveTo(p.currentRoom().getNeighbour(d));
		}
	}

	public String toString() {
		return Translator.translate("Move");
	}
}
