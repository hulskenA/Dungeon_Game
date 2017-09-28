package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;

// BONUS, WILL BE DONE IN THE FUTURE
public class LootAction implements Action  {

	public boolean canBeDoneIn(Room r) {
		return !r.getDeads().isEmpty() && r.isDiscoverd();
	}

	public void doneByIn(Player p, Room r) {
		int goldWin = 0;
		for (GameCharacters gc : r.getDeads())
			goldWin += gc.getGold();
		p.addGold(goldWin);
		r.getDeads().removeAll(r.getDeads());
		System.out.println("\t> After loot all corpses, you win "+goldWin+" gold coins :)");
	}

	public String toString() {
		return "Loot a corpse";
	}
}
