package fil.coo.adventure.entities.monsters.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.MonsterTest;

public class BalrogTest extends MonsterTest {

	@Override
	protected Monster createMonster(int lp, int sp) {
		return new Balrog(lp,sp);
	}
}
