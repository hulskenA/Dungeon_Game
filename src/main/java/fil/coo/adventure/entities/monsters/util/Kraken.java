package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Kraken extends Monster {
	public Kraken() {
		super(60, 15);
	}
	
	public String toString() {
		return "Kraken : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}
}
