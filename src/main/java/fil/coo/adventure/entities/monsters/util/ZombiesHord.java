package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.Monster;

public class ZombiesHord extends Monster {
	public ZombiesHord() {
		super(40, 5);
	}
	
	public String name() {
		return AdventureGame.TRANSLATOR.translate("ZombiesHord");
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.TRANSLATOR.translate("ZombiesHordDescription")+"]";
	}

	public void specialeffect(GameCharacters gm) {
		this.loseLife(-this.getStrength());
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("ZombiesHordEffect1")+" "+this.getStrength()+" "+AdventureGame.TRANSLATOR.translate("ZombiesHordEffect2"));
	}
}
