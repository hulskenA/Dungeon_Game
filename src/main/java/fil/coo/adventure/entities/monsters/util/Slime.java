package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.SpecialMonsterDie;

public class Slime extends Monster implements SpecialMonsterDie {
	public Slime() {
		super(5, 0);
	}
	
	@Override
	public String name() {
		return AdventureGame.translator.translate("Slime");
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.translator.translate("SlimeDescription")+"]";
	}

	@Override
	public void specialeffect() {
		GameCharacters gm;
		if (!this.currentRoom().getCharacters().isEmpty()) {
			gm = this.currentRoom().alea();
			gm.addStrength(5);
			gm.loseLife(-5);
			System.out.println("\t> "+AdventureGame.translator.translate("SlimeEffect1")+" "+gm.name()+" "+AdventureGame.translator.translate("SlimeEffect2"));
		}
	}

	@Override
	public void die() {
		super.die();
		this.specialeffect();
	}
}
