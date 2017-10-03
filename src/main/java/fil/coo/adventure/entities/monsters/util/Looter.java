package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.entities.monsters.SpecialMonsterAttack;

/**
 * This class represents the Looter monster :
 * The looter is a special monster, in the sense of it's attack is different than
 * that of a regular monster.
 * While attacking the looter has a random chance of stealing a small portion of
 * the player's gold.
 * When the looter dies, however, he will drop all gold that he has stolen from
 * other characters.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Looter extends SpecialMonsterAttack {
	public Looter(int lp, int sp) {
		super(lp, sp);
	}
	
	@Override
	public String name() {
		return Translator.translate("Looter");
	}

	@Override
	/**
	 * See Lookable interface documentation
	 */
	public String description() {
		return this.name()+"\n\t["+Translator.translate("LooterDescription")+"]";
	}

	/**
	 * See SpecialMonster&SpecialMonsterAttack documentation
	 */
	public void onAttackEffect(GameCharacter gm) {
		gm.addGold(-10);
		this.addGold(10);
		System.out.println("\t> "+Translator.translate("LooterEffect"));
	}
}
