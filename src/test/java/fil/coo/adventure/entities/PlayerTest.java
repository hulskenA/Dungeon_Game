package fil.coo.adventure.entities;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import fil.coo.adventure.entities.actions.Action;
import fil.coo.adventure.places.Room;

public class PlayerTest extends GameCharacterTest {

	private class MockAction implements Action {
		public boolean canBeDoneIn(Room r) {
			return true;
		}
		public void doneBy(Player p) {
			return;
		}
	}
	
	protected GameCharacter createGameCharacter(int lp, int sp) {
		return new Player(lp,sp);
	}
	
	@Test
	public void addCapabilityAddsCapbilityToThePlayerAndCanDoReturnsCapabilitiesTest() {
		Player p = new Player(100,15);
		Action a1 = new MockAction();
		Action a2 = new MockAction();
		p.addCapability(a1);
		assertTrue(p.canDo().contains(a1));
		p.addCapability(a2);
		assertTrue(p.canDo().contains(a2));
	}
	

	@Override
	public void dieTest() {
		// For a player the die method only kills him
		Player p = new Player(100,15);
		assertTrue(p.isAlive());
		p.die();
		assertFalse(p.isAlive());
	}
	
	protected void specialInteraction(GameCharacter attacker, GameCharacter attacked) {
		// The other character attacks back when the character issuing the attack is a player.
		attacked.attack(attacker);
	}

}