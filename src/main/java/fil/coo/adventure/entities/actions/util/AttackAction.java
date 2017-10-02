package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.ListChoser;

public class AttackAction implements Action {

	public boolean canBeDoneIn(Room r) {
		/* There must be at least 1 monster in the room for the player to attack */
		return !r.getCharacters().isEmpty() || !r.isDiscoverd();
	}
	
	public void doneByIn(Player p, Room r) {
		if (!r.isDiscoverd()) {
			p.loseLife(5);
			System.out.println("\t> "+AdventureGame.translator.translate("AttackActionWhenItsDark"));
		} else {
			/* We let the player choose will monster he wants to attack */
			GameCharacters m = ListChoser.chose(AdventureGame.translator.translate("AttackActionAsk"), r.getCharacters());
			/* We attack the monster */
			if (m != null)
				p.attack(m);
			else
				System.out.println("\t> "+AdventureGame.translator.translate("AttackActionAborded"));
		}
	}
	
	public String toString() {
		return AdventureGame.translator.translate("Attack");
	}
}
