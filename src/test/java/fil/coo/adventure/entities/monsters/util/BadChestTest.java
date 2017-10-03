package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.SpecialMonster;
import fil.coo.adventure.entities.monsters.SpecialMonsterTest;

public class BadChestTest extends SpecialMonsterTest {

	@Override
	protected SpecialMonster createSpecialMonster(int lp, int sp) {
		return new BadChest(lp,sp);
	}

}
