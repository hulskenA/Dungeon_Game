package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.monsters.Monster;

public class Balrog extends Monster {
	public Balrog() {
		super(80, 25);
	}
	
	@Override
	public String name() {
		return AdventureGame.translator.translate("Balrog");
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.translator.translate("BalrogDescription")+"]";
	}
}
