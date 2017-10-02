package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.SpecialMonsterAttack;

public class ZombiesHord extends SpecialMonsterAttack {
	public ZombiesHord() {
		super(40, 5);
	}
	
	@Override
	public String name() {
		return AdventureGame.translator.translate("ZombiesHord");
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.translator.translate("ZombiesHordDescription")+"]";
	}

	@Override
	public void specialeffect(GameCharacters gm) {
		gm.loseLife(this.getStrength());
		this.loseLife(-this.getStrength());
		System.out.println("\t> "+AdventureGame.translator.translate("ZombiesHordEffect1")+" "+this.getStrength()+" "+AdventureGame.translator.translate("ZombiesHordEffect2"));
	}
}
