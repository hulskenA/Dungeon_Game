package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.monsters.Monster;

public class Goblin extends Monster {
	public Goblin() {
		super(15, 5);
	}
	
	public String name() {
		return AdventureGame.TRANSLATOR.translate("Goblin");
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.TRANSLATOR.translate("GoblinDescription")+"]";
	}
}
