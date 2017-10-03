package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the dragon monster :
 * It is a regular monster.
 * NB: Created specifically for the exit room as a sorts of `final boss`
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class Dragon extends Monster {
	public Dragon(int lp, int sp) {
		super(lp, sp);
	}
	
	@Override
	public String name() {
		return Translator.translate("Dragon");
	}
	
	@Override
	/**
	 * See Lookable interface documentation
	 */
	public String description() {
		return this.name()+"\n\t["+Translator.translate("DragonDescription")+"]";
	}
}
