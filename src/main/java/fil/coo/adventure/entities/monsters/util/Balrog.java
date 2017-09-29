package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.monsters.Monster;

public class Balrog extends Monster {
	public Balrog() {
		super(80, 25);
	}
	
	public String name() {
		return "Balrog";
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.TRANSLATOR.translate("BalrogDescription")+"]";
	}
}
