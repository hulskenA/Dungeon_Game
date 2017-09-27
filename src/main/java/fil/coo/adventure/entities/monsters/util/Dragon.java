package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Dragon extends Monster {
	public Dragon() {
		super(100, 25);
	}
	
	public String toString() {
		return "Dragon : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}
}
