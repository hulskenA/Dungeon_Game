package fil.coo.adventure.entities.actions.util;

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
			System.out.println("\t> Vous faite des moulinés avec votre épée dans le noire et comme vous n'êtes vraiment pas une lumière vous avez réussi à vous cognier la tête avec.\n\t> You lost 5 Life points... *Asshole*");
		} else {
			/* We let the player choose will monster he wants to attack */
			GameCharacters m = ListChoser.chose("Who will you attack?", r.getCharacters());
			/* We attack the monster */
			if (m != null)
				p.attack(m);
			else
				System.out.println("\t> Vous n'êtes qu'un couard, vous n'ôsez attaquer personne");
		}
	}
	
	public String toString() {
		return "Attack";
	}
}
