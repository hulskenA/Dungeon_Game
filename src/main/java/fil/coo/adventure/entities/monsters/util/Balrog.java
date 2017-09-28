package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Balrog extends Monster {
	public Balrog() {
		super(80, 25);
	}
	
	public String toString() {
		return "Balrog : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}

	@Override
	public String description() {
		return "Balrog\n\t[Venu des plus profondes entrailles de la Terre, cette créature de feu et de ténèbre veut votre mort plus que tout au monde (Fuyez pauvres fous)]";
	}
}
