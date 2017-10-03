package fil.coo.adventure.entities.monsters;

public abstract class SpecialMonsterDieTest extends SpecialMonsterTest {

	@Override
	protected SpecialMonster createSpecialMonster(int lp, int sp) {
		return this.createSpecialMonsterDie(lp, sp);
	}
	
	protected abstract SpecialMonsterDie createSpecialMonsterDie(int lp, int sp);
}
