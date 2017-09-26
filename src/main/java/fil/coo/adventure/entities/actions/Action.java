package fil.coo.adventure.entities.actions;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.places.Room;

public interface Action {

	/**
	 * This method defines under what conditions this action is available, and the player is able to perform it
	 * @param r The room that we will be testing 
	 * @return boolean Whether we can perform the action in the room r or not.
	 */
	public boolean canBeDoneIn(Room r);
	
	/**
	 * This method performs this action by the given player p in the given room r.
	 * It is recommended that a call of this method is preceded by a call to the canBeDoneIn method!
	 * @param p The player that will perform the action.
	 * @param r The room in which the action will be performed.
	 */
	public void doneByIn(Player p, Room r);
}
