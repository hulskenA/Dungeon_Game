package fil.coo.adventure.util;

/**
 * This interface is used to give a common type to all the objects
 * that can be looked at by the Look Action.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public interface Lookable {
	/**
	 * This returns the description that will be printed to the screen
	 * when the player decides to look at the object implementing this
	 * interface.
	 * @return this object's description for the player to see.
	 */
	public String description();
}
