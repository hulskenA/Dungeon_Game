package fil.coo.adventure.entities.items;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.Lookable;

/**
 * The item interface gives a common type for all the usable items in the game. 
 * It must be implemented by any new class that wishes to be used as an item in
 * the game. It has two methods :
 * - isUsedBy(Player) : that defines the behavior of the item.
 * - description(void) : that comes from the Lookable interface (see doc).
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public interface Item extends Lookable {

	/**
	 * This method defines what happens when a player uses this item.
	 * @param player The player that has used the item.
	 */
	public abstract void isUsedBy(Player player);
	
	/**
	 * Method that must be implemented to satisfy the Lookable interface.
	 * (for more info, check Lookable documentation)
	 */
	public abstract String description();
	
}
