package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.SpecialMonsterAttack;

public class Looter extends SpecialMonsterAttack {
	public Looter() {
		super(20, 20);
	}
	
	@Override
	public String name() {
		return AdventureGame.translator.translate("Looter");
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.translator.translate("LooterDescription")+"]";
	}

	public void specialeffect(GameCharacters gm) {
		gm.addGold(-10);
		this.addGold(10);
		System.out.println("\t> "+AdventureGame.translator.translate("LooterEffect"));
	}
}
