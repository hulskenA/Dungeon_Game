package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.MonsterTest;

public class KrakenTest extends MonsterTest {

	@Override
	protected Monster createMonster(int lp, int sp) {
		return new Kraken(lp,sp);
	}

}
