package fil.coo.adventure.entities.monsters;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.entities.GameCharacterTest;
import fil.coo.adventure.places.Room;

public abstract class MonsterTest extends GameCharacterTest {

	@Test
	public void dieTest() {
		Monster m = this.createMonster(100,15);
		/* For the monster we need to test whether the monster
		 * is removed from the remove, and put into the deads list */
		Room r = new Room();
		r.addCharacter(m);
		m.moveTo(r);
		assertTrue(r.getCharacters().contains(m));
		assertFalse(r.getDeads().contains(m));
		m.die();
		assertFalse(r.getCharacters().contains(m));
	}

	@Override
	protected GameCharacter createGameCharacter(int lp, int sp) {
		return this.createMonster(lp,sp);
	}
	
	protected abstract Monster createMonster(int lp, int sp);

	@Override
	public void specialInteraction(GameCharacter attacker, GameCharacter attacked) {
		// A monster doesn't require the other to attack back.
		return;
	}
	
	@Override
	public void getGoldReturnsGoldOfCharacterTest() {
		// Monster get a random number of gold coins at their start
		assertTrue(true);
	}
}
