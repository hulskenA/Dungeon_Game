package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;

public class SuicideAction implements Action {

	public boolean canBeDoneIn(Room r) {
		return true;
	}

	public void doneByIn(Player p, Room r) {
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("SuicideEffect"));
		p.die();
	}

	public String toString() {
		return AdventureGame.TRANSLATOR.translate("Suicide");
	}

}
