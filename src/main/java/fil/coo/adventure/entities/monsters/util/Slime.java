package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.Monster;

public class Slime extends Monster {
	public Slime() {
		super(5, 0);
	}
	
	public String name() {
		return "Slime";
	}

	@Override
	public String description() {
		return this.name()+"\n\t[une petite boule visqueuse et répugnante, je devrais pouvoir l'écraser sous ma chaussure mais ça risque de me coller dessus]";
	}

	public void specialeffect(GameCharacters gm) {
		gm.addStrength(5);
		gm.loseLife(-5);
		System.out.println("\t> ce truc était radioactif, du coup en l'écrasant les projections en rendu le "+gm.name()+" plus fort de 5 points de vie et de force");
	}
	
	public void die() {
		super.die();
		if (!this.currentRoom().getCharacters().isEmpty())
			this.specialeffect(this.currentRoom().alea());
	}
}
