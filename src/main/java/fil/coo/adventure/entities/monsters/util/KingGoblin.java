
package fil.coo.adventure.entities.monsters.util;



import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.SpecialMonsterAttack;

public class KingGoblin extends SpecialMonsterAttack {
	public KingGoblin() {
		super(30, 5);
	}
	
	@Override
	public String name() {
		return AdventureGame.translator.translate("KingGoblin");
	}
	
	@Override
	public void specialeffect(GameCharacters gm) {		
		gm.currentRoom().addCharacter(new Goblin());
		System.out.println(AdventureGame.translator.translate("KingGoblinEffect"));
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.translator.translate("KingGoblinDescription")+"]";
	}

}
