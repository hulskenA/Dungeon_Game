package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;

/**
 * This class defines the behavior for the Suicide Action :
 * Allows the player to end his life at any given point during the game,
 * as this action has no requirements and is always possible.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class SuicideAction implements Action {

	/**
	 * See Action interface documentation
	 */
	public boolean canBeDoneIn(Room r) {
		return true;
	}

	/**
	 * See Action interface documentation
	 */
	public void doneBy(Player p) {
		System.out.println("\t> "+Translator.translate("SuicideEffect"));
		p.die();
	}

	public String toString() {
		return Translator.translate("Suicide");
	}

}
