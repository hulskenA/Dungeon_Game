package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.ListChoser;

/**
 * This class defines the Attack behavior:
 * It displays a list of monsters, from which the player has to chose one to attack.
 * Then it uses the attack method of the GameCharacter attack in order to attack the
 * chosen monster.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class AttackAction implements Action {

	/**
	 * See Action interface documentation
	 */
	public boolean canBeDoneIn(Room r) {
		/* There must be at least 1 monster in the room for the player to attack */
		return !r.getCharacters().isEmpty() || !r.isDiscoverd();
	}
	
	/**
	 * See Action interface documentation
	 */
	public void doneBy(Player p) {
		if (!p.currentRoom().isDiscoverd()) {
			p.loseLife(5);
			System.out.println("\t> "+Translator.translate("AttackActionWhenItsDark"));
		} else {
			/* We let the player choose will monster he wants to attack */
			GameCharacter m = ListChoser.chose(Translator.translate("AttackActionAsk"), p.currentRoom().getCharacters());
			/* We attack the monster */
			if (m != null)
				p.attack(m);
			else
				System.out.println("\t> "+Translator.translate("AttackActionAborded"));
		}
	}
	
	public String toString() {
		return Translator.translate("Attack");
	}
}
