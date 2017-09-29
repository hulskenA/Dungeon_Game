package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.Monster;

public class Slime extends Monster {
	public Slime() {
		super(5, 0);
	}
	
	public String name() {
		return "Slime";
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.TRANSLATOR.translate("SlimeDescription")+"]";
	}

	public void specialeffect(GameCharacters gm) {
		gm.addStrength(5);
		gm.loseLife(-5);
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("SlimeEffect1")+gm.name()+AdventureGame.TRANSLATOR.translate("SlimeEffect2"));
	}
	
	public void die() {
		super.die();
		if (!this.currentRoom().getCharacters().isEmpty())
			this.specialeffect(this.currentRoom().alea());
	}
}
