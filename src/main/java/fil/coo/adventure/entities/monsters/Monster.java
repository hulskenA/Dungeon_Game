package fil.coo.adventure.entities.monsters;

import java.util.Random;

import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.util.langages.Translator;

/**
 * Defines the basic behavior for a Monster in our dungeon game:
 * When a player attacks a monster it will attack back.
 * When a monster dies, it is removed from the list of characters of the room
 * and put into the list of dead characters, to be later looted by the player.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public abstract class Monster extends GameCharacter {
	public abstract String name();

	public Monster(int lP, int st) {
		super(lP, st);
		Random r = new Random();
		this.gold = r.nextInt(150);
	}
	
	/**
	 * Prints a message describing what happened when this object hits another
	 * In this case (Monster), this prints a message telling the player that the monster did X damage to him.
	 */
	protected void hit() {
		System.out.println("\t> "+Translator.translate("ItRipostes")+" "+this.getStrength()+" "+Translator.translate("LifePoints"));		
	}
	
	/**
	 * Prints a message describing what happened when this object gets hit by another
	 * In this case (Monster, this only prints a message telling the player that he has X life points left.
	 * @param attacker The player that has attacked this monster
	 */
	protected void gotHitBy(GameCharacter attacker) {
		System.out.println("\n\t> "+Translator.translate("Now")+" "+attacker.getLifePoints()+" "+Translator.translate("LP")+"\n\t> "+Translator.translate("ItHave")+" "+this.getLifePoints()+" "+Translator.translate("LP"));
	}

	/**
	 * Defines what happens when a monster dies. In the case of a regular monster (Monster.java) a message
	 * is displayed to the player, telling him that the monster is now dead and the monster is transfered
	 * from the list of monsters of the room it is in, to the list of dead characters of that room.
	 */
	public void die() {
		this.loseLife(this.getLifePoints());
		System.out.println("\t> "+Translator.translate("MonsterDie"));
		this.currentRoom().removeCharacter(this);
		this.currentRoom().addDead(this);
	}
	
	/**
	 * Gives a short description of the object. In this case of the life and strength points of the monster
	 * @return A string containing Monster and it's life and strength points.
	 */
	public String toString() {
		return this.name()+" : "+Translator.translate("LP")+":"+this.getLifePoints()+", "+Translator.translate("SP")+": "+this.getStrength();
	}
	
	
}
