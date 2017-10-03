package fil.coo.adventure.entities.monsters;

import java.util.Random;

import fil.coo.adventure.entities.GameCharacter;

/**
 * Defines the behavior for a special monster :
 * A special monster attacks attack in the same way a regular monster does,
 * except that the special monster has a chance of performing a special attack move
 * (dealing bonus damage, spawning other monsters, etc...)
 * When a special monster dies, it has a special effect (doing bonus damage to
 * the player, healing other monsters, etc...)
 * In every other aspect a special monster ressembles a regular one.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public abstract class SpecialMonster extends Monster {
	
	public SpecialMonster(int lP, int st) {
		super(lP, st);
	}
	
	/**
	 * Defines what happens when a SpecialMonster attacks another GameCharacter. A special monster attacks
	 * in the same way that a regular monster (Monster) attacks, except that there is a random chance that
	 * the SpecialMonster applies a onAttackEffect. This onAttackEffect is an abstract method that must be
	 * defined for the classes that extend this one.
	 */
	public void attack(GameCharacter theOtherCharacterToAttack) {
		Random r = new Random();
		if (r.nextBoolean())
			this.onAttackEffect(theOtherCharacterToAttack);
		// The special monster attacks like a normal monster after it applies its special effect
		super.attack(theOtherCharacterToAttack);
	}

	/**
	 * Defines what happens when a SpecialMonster dies. What happens is the same thing as a regular monster
	 * (Monster) except that there is a bonus onDieEffect that is applied. This onDieEffect is an abstract
	 * method that must be defined for the classes that extend this one.
	 */
	public void die() {
		// The creature dies like any other
		super.die();
		// And then the special effect is applied
		this.onDieEffect();
	}
	
	/**
	 * Method that defines what effect this special monster will have when 
	 * attacking a player.
	 * @param gm The GameCharacter that will be attacked by the monster (usually the player)
	 */
	public abstract void onAttackEffect(GameCharacter gm);
	
	/**
	 * Method that defines the special behavior of a monster when it dies.
	 */
	public abstract void onDieEffect();
}
