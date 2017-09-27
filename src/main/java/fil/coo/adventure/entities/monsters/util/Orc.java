package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Orc extends Monster {
	public Orc() {
		super(40, 10);
	}
	
	public String toString() {
		return "Orc : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}
}
