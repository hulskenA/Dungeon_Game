package adventure.entities.actions;

import adventure.places.Room;

public class Attack {
	public boolean isPossible(Room r) {
		return !r.getMonsters().isEmpty();
	}
}
