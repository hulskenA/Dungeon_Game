package fil.coo.adventure.entities.actions.util;

import java.util.ArrayList;
import java.util.List;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Direction;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.ListChoser;

public class MoveAction implements Action {

	public boolean canBeDoneIn(Room r) {
		/* A player can move if there aren't any live monsters in the room */
		return r.getMonsters().isEmpty();
	}

	public void doneByIn(Player p, Room r) {
		List<Direction> directions = new ArrayList<Direction>();
		directions.addAll(r.getPossibleDirections());
		Direction d = ListChoser.chose("Which direction will you take?",directions, true);
		
	}

	public String toString() {
		return "Move";
	}
}
