package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.SpecialMonsterAttack;
import fil.coo.adventure.entities.monsters.SpecialMonsterAttackTest;

public class KingGoblinTest extends SpecialMonsterAttackTest {

	@Override
	protected SpecialMonsterAttack createSpecialMonsterAttack(int lp, int sp) {
		return new KingGoblin(lp,sp);
	}

	@Override
	protected int specialAttackDamage(int sp) {
		return 0; // The king goblin does no bonus damage, just summons a goblin
	}

	
}
