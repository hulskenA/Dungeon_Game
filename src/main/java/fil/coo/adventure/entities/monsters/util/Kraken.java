package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Kraken extends Monster {
	public Kraken() {
		super(60, 15);
	}
	
	public String toString() {
		return "Kraken : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}

	@Override
	public String description() {
		return "Kraken\n\t[Dans ce petit lac (étonnant d'en trouver un comme ça en plein milieu de ce donjon, mais ne nous posons pas trop de questions) se trouve une bête avec plein de tentacules *Fallait lire avec une voix mystérieuse* Sauf que personne ne sait de quoi il sagit exactement]";
	}
}
