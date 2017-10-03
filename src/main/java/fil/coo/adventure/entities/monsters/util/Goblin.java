package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the goblin monster :
 * It is a regular monster. 
 * The goblin king has a random chance of calling a 
 * goblin to his side while attacking.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Goblin extends Monster {
	public Goblin(int lp, int sp) {
		super(lp,sp);
	}
	
	@Override
	public String name() {
		return Translator.translate("Goblin");
	}

	@Override
	/**
	 * See Lookable interface documentation
	 */
	public String description() {
		return this.name()+"\n\t["+Translator.translate("GoblinDescription")+"]";
	}
}
