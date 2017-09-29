package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.Monster;

public class Looter extends Monster {
	public Looter() {
		super(20, 20);
	}
	
	public String name() {
		return AdventureGame.TRANSLATOR.translate("Looter");
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.TRANSLATOR.translate("LooterDescription")+"]";
	}

	public void specialeffect(GameCharacters gm) {
		gm.addGold(-10);
		this.addGold(10);
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("LooterEffect"));
	}
}
