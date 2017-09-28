package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.monsters.Monster;

public class Slime extends Monster {
	public Slime() {
		super(5, 0);
	}
	
	public String toString() {
		return "Slime : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}

	@Override
	public String description() {
		return "Slime\n\t[une petite boule visqueuse et répugnante, je devrais pouvoir l'écraser sous ma chaussure mais ça risque de me coller dessus]";
	}
}
