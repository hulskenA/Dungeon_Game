package fil.coo.adventure.entities.actions;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.places.Room;

/**
 * This interface indicates which methods the Action classes will have to implement
 * in order to define how an action affects the player and the room he is in.
 * Any class that wants to be used as an Action in the game must implement this
 * interface.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
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
	 */
	public void doneBy(Player p);
}
