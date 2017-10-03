package fil.coo.adventure.entities.monsters;

/**
 * A category of SpecialMonster that doesn't have a special onDieEffect but instead has
 * only a particular onAttackEffect. It simply defines a empty behavior for the on-
 * DieEffect method. However classes extending this one must provide a definit-
 * ion for the onAttackEffect abstract method of SpecialMonster.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public abstract class SpecialMonsterAttack extends SpecialMonster {

	public SpecialMonsterAttack(int lP, int st) {
		super(lP, st);
	}

	public final void onDieEffect() {
		//Do nothing
		return;
	}
}
