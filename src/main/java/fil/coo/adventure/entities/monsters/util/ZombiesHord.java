package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.*;

public class ZombiesHord extends Monster implements SpecialMonster {
	public ZombiesHord() {
		super(40, 5);
	}
	
	public String toString() {
		return "ZombiesHord : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}

	@Override
	public String description() {
		return "ZombiesHord\n\t[oh ce zombi n'a pas trop l'air méchant, mais attends, il n'est pas seul... Oh merde il sont beaucoups trop nombreux et ils ont faim en plus]";
	}

	public void specialeffect(GameCharacters gm) {
		gm.loseLife(this.getStrength());
		this.loseLife(-this.getStrength());
		System.out.println("\t> Un zombi vous a mordu, du coup vous perdez 5 points de vie tandis que le horde en gagne la même quantité");
	}
}
