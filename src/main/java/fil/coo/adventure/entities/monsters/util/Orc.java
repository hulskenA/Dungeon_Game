package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.monsters.Monster;

public class Orc extends Monster {
	public Orc() {
		super(40, 10);
	}
	
	@Override
	public String name() {
		return AdventureGame.translator.translate("Orc");
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.translator.translate("OrcDescription")+"]";
	}
}
