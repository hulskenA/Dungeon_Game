package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.monsters.Monster;

/**
 * This class represents the Orc monster :
 * The orc is a regular monster.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Orc extends Monster {
	public Orc(int lp,int sp) {
		super(lp, sp);
	}
	
	@Override
	public String name() {
		return Translator.translate("Orc");
	}

	@Override
	/**
	 * See Lookable interface documentation
	 */
	public String description() {
		return this.name()+"\n\t["+Translator.translate("OrcDescription")+"]";
	}
}
