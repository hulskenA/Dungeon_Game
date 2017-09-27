package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class ZombiesHord extends Monster {
	public ZombiesHord() {
		super(40, 5);
	}
	
	public String toString() {
		return "ZombiesHord : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}
}
