package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;

/**
 * This class defines the behavior for the Loot Action :
 * Gives the option to the player to loot the corpses in the room (if any)
 * , recovering any gold that might be on them.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class LootAction implements Action  {

	/**
	 * See Action interface documentation.
	 */
	public boolean canBeDoneIn(Room r) {
		return !r.getDeads().isEmpty() && r.isDiscoverd();
	}

	/**
	 * See Action interface documentation.
	 */
	public void doneBy(Player p) {
		int goldWin = 0;
		for (GameCharacter gc : p.currentRoom().getDeads())
			goldWin += gc.getGold();
		p.addGold(goldWin);
		p.currentRoom().getDeads().removeAll(p.currentRoom().getDeads());
		System.out.println("\t> "+Translator.translate("LootWin1")+" "+goldWin+" "+Translator.translate("LootWin2")+" :)");
	}

	public String toString() {
		return Translator.translate("Loot");
	}
}
