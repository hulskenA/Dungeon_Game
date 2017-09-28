package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class ZombiesHord extends Monster {
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
}
