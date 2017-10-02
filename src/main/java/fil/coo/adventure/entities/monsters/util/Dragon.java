package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.monsters.Monster;

public class Dragon extends Monster {
	public Dragon() {
		super(100, 25);
	}
	
	@Override
	public String name() {
		return AdventureGame.translator.translate("Dragon");
	}
	
	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.translator.translate("DragonDescription")+"]";
	}
}
