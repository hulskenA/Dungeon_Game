package fil.coo.adventure.entities.actions.util;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Direction;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.ListChoser;

public class MoveAction implements Action {

	public boolean canBeDoneIn(Room r) {
		/* A player can move if there aren't any live monsters in the room */
		return r.getCharacters().isEmpty() && r.isDiscoverd();
	}

	public void doneByIn(Player p, Room r) {
		List<Direction> directions = new ArrayList<Direction>();
		directions.addAll(r.getPossibleDirections());
		Direction d = ListChoser.chose(AdventureGame.translator.translate("MoveAsk"),directions);
		if (d == null) {
			System.out.println("\t> "+AdventureGame.translator.translate("MoveRest"));
		} else {
			System.out.println("\t> "+AdventureGame.translator.translate("MoveNextRoom"));
			p.moveTo(r.getNeighbour(d));
		}
	}

	public String toString() {
		return AdventureGame.translator.translate("Move");
	}
}
