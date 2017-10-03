package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.entities.monsters.SpecialMonsterAttack;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the hord of zombies monster :
 * It is a special monster, in the sense that it's attack is different 
 * than that of a regular monster.
 * When the hord attacks it has a chance of restoring a part of it's 
 * health.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class ZombiesHord extends SpecialMonsterAttack {
	public ZombiesHord(int lp, int sp) {
		super(lp, sp);
	}
	
	@Override
	public String name() {
		return Translator.translate("ZombiesHord");
	}

	@Override
	/**
	 * See Lookable interface documentation
	 */
	public String description() {
		return this.name()+"\n\t["+Translator.translate("ZombiesHordDescription")+"]";
	}

	@Override
	/**
	 * See SpecialMonster&SpecialMonsterAttack documentation
	 */
	public void onAttackEffect(GameCharacter gm) {
		gm.loseLife(this.getStrength());
		this.loseLife(-this.getStrength());
		System.out.println("\t> "+Translator.translate("ZombiesHordEffect1")+" "+this.getStrength()+" "+Translator.translate("ZombiesHordEffect2"));
	}
}
