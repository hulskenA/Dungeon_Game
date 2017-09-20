package adventure.entities.actions;

import adventure.places.Room;

public interface Actions {
	public boolean isPossible(Room r);
	public void execute();
}
