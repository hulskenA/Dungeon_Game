package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.monsters.Monster;

public class Orc extends Monster {
	public Orc() {
		super(40, 10);
	}
	
	public String name() {
		return AdventureGame.TRANSLATOR.translate("Orc");
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.TRANSLATOR.translate("OrcDescription")+"]";
	}
}
