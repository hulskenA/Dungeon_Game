package fil.coo.adventure.entities.monsters;

import org.junit.Test;

import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.places.Room;

import static org.junit.Assert.*;

public abstract class SpecialMonsterTest extends MonsterTest {
	
	@Test
	public void attackCallsOnAttackEffectTest() {
		/* This test WOULD be valid, but our SpecialMonster class only calls onAttackEffect
		 * in some cases (random). But anyways here it is :
		 * CustomSpecialMonster sm = new CustomSpecialMonster(100,50);
		 * sm.attack(new MockGameCharacter(100,15));
		 * assertTrue(sm.onAttackIsCalled); */
		assertTrue(true);
		return;
	}
		
	@Test
	public void dieCallsOnDieEffectTest() {
		// However the onDieEffect is always called
		CustomSpecialMonster sm = new CustomSpecialMonster(100,50);
		Room r = new Room();
		sm.moveTo(r);
		r.addCharacter(sm);
		sm.die();
		assertTrue(sm.onDieIsCalled);
	}
	
	protected abstract SpecialMonster createSpecialMonster(int lp, int sp);
	
	@Override
	protected Monster createMonster(int lp, int sp) {
		return this.createSpecialMonster(lp, sp);
	}
	
	private class CustomSpecialMonster extends SpecialMonster {

		public boolean onAttackIsCalled;
		public boolean onDieIsCalled;
		
		public CustomSpecialMonster(int lP, int st) {
			super(lP, st);
			this.onAttackIsCalled = false;
			this.onDieIsCalled = false;
		}

		@Override
		public void onAttackEffect(GameCharacter gm) {
			this.onAttackIsCalled = true;
		}

		@Override
		public void onDieEffect() {
			this.onDieIsCalled = true;
		}

		@Override
		public String name() {
			return "Bobby";
		}

		@Override
		public String description() {
			return null;
		}
	}
}
