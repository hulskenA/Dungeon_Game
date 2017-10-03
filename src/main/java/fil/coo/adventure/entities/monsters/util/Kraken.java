package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the kraken monster :
 * It is a regular monster.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Kraken extends Monster {
	public Kraken(int lp, int sp) {
		super(lp, sp);
	}
	
	@Override
	public String name() {
		return Translator.translate("Kraken");
	}

	@Override
	/**
	 * See Lookable interface documentation
	 */
	public String description() {
		return this.name()+"\n\t["+Translator.translate("KrakenDescription")+"]";
	}
}
