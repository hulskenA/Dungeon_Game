package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.*;

public class Slime extends Monster implements SpecialMonster {
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

	public void specialeffect(GameCharacters gm) {
		gm.addStrength(5);
		System.out.println("\t> Vous avez gagné 5 points de force car vous vous sentez fort d'avoir exterminé ce truc");
	}
}
