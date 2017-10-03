package fil.coo.adventure.places;

import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the exit room of the game, it inherits everything the 
 * Room class except for the isExit method, that is over-ridden to return true. 
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Exit extends Room {
	public Exit() {
		super();
	}
	
	/**
	 * Over-ridden method of Room, always returns true.
	 */
	public boolean isExit() {
		return true;
	}
	
	public String toString() {
		return Translator.translate("RoomToString");
	}
}
