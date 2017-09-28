package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Balrog extends Monster {
	public Balrog() {
		super(80, 25);
	}
	
	public String name() {
		return "Balrog";
	}

	@Override
	public String description() {
		return this.name()+"\n\t[Venu des plus profondes entrailles de la Terre, cette créature de feu et de ténèbre veut votre mort plus que tout au monde (Fuyez pauvres fous)]";
	}
}
