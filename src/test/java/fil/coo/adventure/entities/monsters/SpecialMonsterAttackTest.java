package fil.coo.adventure.entities.monsters;

import org.junit.Test;

import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.places.Room;

import static org.junit.Assert.*;

public abstract class SpecialMonsterAttackTest extends SpecialMonsterTest {
	
	@Override
	public void attackTest() {
		SpecialMonsterAttack m = this.createSpecialMonsterAttack(100, 15);
		/* The next 3 lines are needed in case the onAttackEffect of certain 
		 * SpecialMonsterAttack is activated (that require a room in order to work) */
		Room r = new Room();
		m.moveTo(r);
		r.addCharacter(m);
		GameCharacter gc = new MockGameCharacter(100,15);
		gc.moveTo(r);
		r.addCharacter(gc);
		m.attack(gc);
		System.out.println(gc.getLifePoints());
		if (gc.getLifePoints()==85)
			assertTrue(true); // Le comportement normal
		else
			assertEquals(85-specialAttackDamage(15),gc.getLifePoints()); // In case of onAttackEffect of certain monsters
			
	}
	
	protected abstract int specialAttackDamage(int sp);

	protected abstract SpecialMonsterAttack createSpecialMonsterAttack(int lp,int sp);
	
	@Override
	protected SpecialMonster createSpecialMonster(int lp, int sp) {
		return this.createSpecialMonsterAttack(lp, sp);
	}

}
