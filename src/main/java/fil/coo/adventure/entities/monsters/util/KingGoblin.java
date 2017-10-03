
package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.entities.monsters.SpecialMonsterAttack;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the Goblin king monster :
 * It is a special monster, in the sense of it's attack is different.
 * It has a random chance of calling a goblin to the room when attacking.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class KingGoblin extends SpecialMonsterAttack {
	public KingGoblin(int lp,int sp) {
		super(lp, sp);
	}
	
	@Override
	public String name() {
		return Translator.translate("KingGoblin");
	}
	
	@Override
	/**
	 * See SpecialMonster&SpecialMonsterAttack documentation
	 */
	public void onAttackEffect(GameCharacter gm) {		
		gm.currentRoom().addCharacter(new Goblin(15,5));
		System.out.println(Translator.translate("KingGoblinEffect"));
	}

	@Override
	/**
	 * See Lookable interface documentation
	 */
	public String description() {
		return this.name()+"\n\t["+Translator.translate("KingGoblinDescription")+"]";
	}

}
