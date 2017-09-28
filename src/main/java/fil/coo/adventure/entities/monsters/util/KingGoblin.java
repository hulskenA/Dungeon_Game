
package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.SpecialMonster;

public class KingGoblin extends Monster implements SpecialMonster {
	public KingGoblin() {
		super(30, 5);
	}
	
	public String toString() {
		return "KingGoblin : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}
	
	public void specialeffect(GameCharacters gm) {
		gm.currentRoom().addCharacter(new Goblin());
		System.out.println("Oh non ce monstre viens de faire appelle à l'un de ces sujets");
	}

	@Override
	public String description() {
		return "KingGoblin\n\t[Encore plus grand, encore plus gros, encore moins de savoir vivre... Et oui c'est bien le roi des Goblins";
	}

}
