package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.SpecialMonsterAttack;
import fil.coo.adventure.entities.monsters.SpecialMonsterAttackTest;

public class LooterTest extends SpecialMonsterAttackTest {

	@Override
	protected SpecialMonsterAttack createSpecialMonsterAttack(int lp, int sp) {
		return new Looter(lp,sp);
	}

	@Override
	protected int specialAttackDamage(int sp) {
		return 0; // The looter does no bonus damage instead steals your gold.
	}

}
