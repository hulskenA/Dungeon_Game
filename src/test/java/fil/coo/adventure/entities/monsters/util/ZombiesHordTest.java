package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.SpecialMonsterAttack;
import fil.coo.adventure.entities.monsters.SpecialMonsterAttackTest;

public class ZombiesHordTest extends SpecialMonsterAttackTest {

	@Override
	protected SpecialMonsterAttack createSpecialMonsterAttack(int lp, int sp) {
		return new ZombiesHord(lp,sp);
	}

	@Override
	protected int specialAttackDamage(int sp) {
		return sp; // does a bonus of their sp
	}

}
