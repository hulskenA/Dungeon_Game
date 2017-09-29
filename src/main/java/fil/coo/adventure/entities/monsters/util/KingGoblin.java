
package fil.coo.adventure.entities.monsters.util;

import java.util.Random;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.Monster;

public class KingGoblin extends Monster {
	public KingGoblin() {
		super(30, 5);
	}
	
	public String name() {
		return AdventureGame.TRANSLATOR.translate("KingGoblin");
	}
	
	public void specialeffect(GameCharacters gm) {
		Random r = new Random();
		if (r.nextBoolean()) {
			gm.currentRoom().addCharacter(new Goblin());
			System.out.println(AdventureGame.TRANSLATOR.translate("KingGoblinEffect"));
		}
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.TRANSLATOR.translate("KingGoblinDescription")+"]";
	}

}
