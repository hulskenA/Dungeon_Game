package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.ListChoser;

public class AttackAction implements Action {

	public boolean canBeDoneIn(Room r) {
		/* There must be at least 1 monster in the room for the player to attack */
		return !r.getMonsters().isEmpty();
	}
	
	public void doneByIn(Player p, Room r) {
		/* We let the player choose will monster he wants to attack */
		Monster m = ListChoser.chose("Which monster will you attack?", r.getMonsters(),true);
		/* We attack the monster */
		 p.attack(m);
	}
	
	public String toString() {
		return "Attack";
	}
}
