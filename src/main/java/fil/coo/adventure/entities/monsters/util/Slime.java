package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Slime extends Monster {
	public Slime() {
		super(5, 0);
	}
	
	public String toString() {
		return "Slime : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}
}
