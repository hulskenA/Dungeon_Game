package adventure.entities.actions;

import adventure.places.Room;

public class Loot {
	public boolean isPossible(Room r) {
		return !r.getDeads().isEmpty();
	}
}
