package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.monsters.Monster;

/**
 * This class represents the balrog monster :
 * It is a regular monster.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Balrog extends Monster {
	public Balrog(int lp, int sp) {
		super(lp,sp);
	}
	
	@Override
	public String name() {
		return Translator.translate("Balrog");
	}

	@Override
	/**
	 * See Lookable interface documentation
	 */
	public String description() {
		return this.name()+"\n\t["+Translator.translate("BalrogDescription")+"]";
	}
}
