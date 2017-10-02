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
		System.out.println("\t> "+AdventureGame.translator.translate("ItRipostes")+" "+this.getStrength()+" "+AdventureGame.translator.translate("LifePoints"));
		if (theOtherCharacterToAttack.isAlive())
			System.out.println("\n\t> "+AdventureGame.translator.translate("Now")+" "+theOtherCharacterToAttack.getLifePoints()+" "+AdventureGame.translator.translate("LP")+"\n\t> "+AdventureGame.translator.translate("ItHave")+" "+this.getLifePoints()+" "+AdventureGame.translator.translate("LP"));
		else
			theOtherCharacterToAttack.die();
	}
	
	public void die() {
		System.out.println("\t> "+AdventureGame.translator.translate("MonsterDie")+" !!! :D");
		this.currentRoom().removeCharacter(this);
		this.currentRoom().addDead(this);
	}
	
	public String toString() {
		return this.name()+" : "+AdventureGame.translator.translate("LP")+":"+this.getLifePoints()+", "+AdventureGame.translator.translate("SP")+": "+this.getStrength();
	}
	
	
}
