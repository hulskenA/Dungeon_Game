package fil.coo.adventure.entities.monsters;

import fil.coo.adventure.entities.GameCharacter;

/**
 * A category of monster that doesn't have a special onAttackEffect but instead has
 * only a particular onDieEffect. It simply defines a empty behavior for the onAt-
 * tackEffect method. However classes extending this one must provide a definit-
 * ion for the onDieEffect abstract method.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public abstract class SpecialMonsterDie extends SpecialMonster {

	public SpecialMonsterDie(int lP, int st) {
		super(lP, st);
	}

	public final void onAttackEffect(GameCharacter gm) {
		// Do nothing.
		return;
	}
}
