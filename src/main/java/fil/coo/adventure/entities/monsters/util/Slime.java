package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.entities.monsters.SpecialMonsterDie;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the Slime monster :
 * The slime a special monster, in the sense of it's death is different than
 * that of a regular monster.
 * When the slime dies, it being a radioactive compound, it's goo sticks to a
 * random monster in the room and gives it +5 life and strength points.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Slime extends SpecialMonsterDie {
	public Slime(int lp,int sp) {
		super(lp, sp);
	}
	
	@Override
	public String name() {
		return Translator.translate("Slime");
	}

	@Override
	/**
	 * See Lookable interface documentation
	 */
	public String description() {
		return this.name()+"\n\t["+Translator.translate("SlimeDescription")+"]";
	}

	@Override
	/**
	 * See SpecialMonster&SpecialMonsterDie documentation
	 */
	public void onDieEffect() {
		GameCharacter gm;
		if (!this.currentRoom().getCharacters().isEmpty()) {
			gm = this.currentRoom().alea();
			gm.addStrength(5);
			gm.loseLife(-5);
			System.out.println("\t> "+Translator.translate("SlimeEffect1")+" "+gm.name()+" "+Translator.translate("SlimeEffect2"));
		}
	}
}
