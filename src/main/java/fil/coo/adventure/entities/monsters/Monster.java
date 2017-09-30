package fil.coo.adventure.entities.monsters;

import java.util.Random;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;

public abstract class Monster extends GameCharacters {
	public abstract String name();

	public Monster(int lP, int st) {
		super(lP, st);
		Random r = new Random();
		this.gold = r.nextInt(150);
	}
	
	@Override
	public void attack(GameCharacters theOtherCharacterToAttack) {
		theOtherCharacterToAttack.loseLife(this.getStrength());
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("ItRipostes")+" "+theOtherCharacterToAttack.getStrength()+" "+AdventureGame.TRANSLATOR.translate("LifePoints"));
		this.specialeffect(theOtherCharacterToAttack);
		if (theOtherCharacterToAttack.isAlive())
			System.out.println("\n\t> "+AdventureGame.TRANSLATOR.translate("Now")+" "+theOtherCharacterToAttack.getLifePoints()+" "+AdventureGame.TRANSLATOR.translate("LP")+"\n\t> "+AdventureGame.TRANSLATOR.translate("ItHave")+" "+this.getLifePoints()+" "+AdventureGame.TRANSLATOR.translate("LP"));
		else
			theOtherCharacterToAttack.die();
	}
	
	public void die() {
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("MonsterDie")+" !!! :D");
		this.currentRoom().removeCharacter(this);
		this.currentRoom().addDead(this);
	}
	
	public String toString() {
		return this.name()+" : "+AdventureGame.TRANSLATOR.translate("LP")+":"+this.getLifePoints()+", "+AdventureGame.TRANSLATOR.translate("SP")+": "+this.getStrength();
	}
	
	public void specialeffect(GameCharacters gm) {}
}
