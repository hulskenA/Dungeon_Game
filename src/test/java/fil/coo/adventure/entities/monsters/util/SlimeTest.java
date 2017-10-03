package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.SpecialMonsterDie;
import fil.coo.adventure.entities.monsters.SpecialMonsterDieTest;

public class SlimeTest extends SpecialMonsterDieTest {

	@Override
	protected SpecialMonsterDie createSpecialMonsterDie(int lp, int sp) {
		return new Slime(lp,sp);
	}

}
