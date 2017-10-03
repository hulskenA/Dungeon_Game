package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.MonsterTest;

public class GoblinTest extends MonsterTest {

	@Override
	protected Monster createMonster(int lp, int sp) {
		return new Goblin(lp,sp);
	}

}
