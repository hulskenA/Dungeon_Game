package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Looter extends Monster {
	public Looter() {
		super(20, 20);
	}
	
	public String toString() {
		return "Looter : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}

	@Override
	public String description() {
		return "Looter\n\t[I hate them, je vais devoir faire attention à mon or parce que J'AIME l'argeeeeent]";
	}
}
