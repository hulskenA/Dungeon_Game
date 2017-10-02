package fil.coo.adventure.entities.monsters;

import java.util.Random;

import fil.coo.adventure.entities.GameCharacters;

public abstract class SpecialMonsterAttack extends Monster {

	public abstract void specialeffect(GameCharacters gm);
	
	public SpecialMonsterAttack(int lP, int st) {
		super(lP, st);
	}
	
	public void attack (GameCharacters theOtherCharacterToAttack) {
		Random r = new Random();
		if (r.nextBoolean())
			this.specialeffect(theOtherCharacterToAttack);
		super.attack(theOtherCharacterToAttack);
	}
	
}
