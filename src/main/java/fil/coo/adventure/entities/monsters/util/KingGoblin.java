
package fil.coo.adventure.entities.monsters.util;

import java.util.Random;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.Monster;

public class KingGoblin extends Monster {
	public KingGoblin() {
		super(30, 5);
	}
	
	public String name() {
		return "KingGoblin";
	}
	
	public void specialeffect(GameCharacters gm) {
		Random r = new Random();
		if (r.nextBoolean()) {
			gm.currentRoom().addCharacter(new Goblin());
			System.out.println("Oh non ce monstre viens de faire appelle à l'un de ces sujets");
		}
	}

	@Override
	public String description() {
		return this.name()+"\n\t[Encore plus grand, encore plus gros, encore moins de savoir vivre... Et oui c'est bien le roi des Goblins";
	}

}
