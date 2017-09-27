package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Goblin extends Monster {
	public Goblin() {
		super(15, 5);
	}
	
	public String toString() {
		return "Goblin : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}
}
