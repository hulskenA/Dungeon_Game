package adventure.entities.actions;

import adventure.places.Room;

public class Use {
	public boolean isPossible(Room r) {
		return !r.getItems().isEmpty();
	}
}
