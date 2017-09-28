package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.ListChoser;

public class AttackAction implements Action {

	public boolean canBeDoneIn(Room r) {
		/* There must be at least 1 monster in the room for the player to attack */
		return !r.getCharacters().isEmpty();
	}
	
	public void doneByIn(Player p, Room r) {
		/* We let the player choose will monster he wants to attack */
		GameCharacters m = ListChoser.chose("Who will you attack?", r.getCharacters());
		/* We attack the monster */
		if (m != null)
			p.attack(m);
		else
			System.out.println("\tYou don't attack someone");
	}
	
	public String toString() {
		return "Attack";
	}
}
