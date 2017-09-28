package fil.coo.adventure.entities.monsters;

import java.util.Random;

import fil.coo.adventure.entities.GameCharacters;

public abstract class Monster extends GameCharacters {
	public Monster(int lP, int st) {
		super(lP, st);
		Random r = new Random();
		this.gold = r.nextInt(150);
	}
	
	@Override
	public void attack(GameCharacters theOtherCharacterToAttack) {
		theOtherCharacterToAttack.loseLife(this.getStrength());
		System.out.println("\t> It ripostes and you lost "+theOtherCharacterToAttack.getStrength()+" Life Points");
		if (theOtherCharacterToAttack.isAlive())
			System.out.println("\n\t> Now you have "+this.getLifePoints()+" LP");
		else
			theOtherCharacterToAttack.die();
	}
	
	public void die() {
		System.out.println("\t> It is died now, you kill it !!! :D");
		this.currentRoom().removeCharacter(this);
		this.currentRoom().addDead(this);
	}
}
