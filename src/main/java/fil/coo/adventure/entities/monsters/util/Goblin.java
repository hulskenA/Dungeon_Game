package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.monsters.Monster;

public class Goblin extends Monster {
	public Goblin() {
		super(15, 5);
	}
	
	@Override
	public String name() {
		return AdventureGame.translator.translate("Goblin");
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.translator.translate("GoblinDescription")+"]";
	}
}
