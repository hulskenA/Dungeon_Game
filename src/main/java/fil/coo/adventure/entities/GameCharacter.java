package fil.coo.adventure.entities;

import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.Lookable;

/**
 * The GameCharacter abstract class contains most of the attributes, getters/setters for 
 * our Player and Monsters. 
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public abstract class GameCharacter implements Lookable {

	protected Room currentRoom;
	protected int LifePoints;
	protected int strength;
	protected int gold;

	public GameCharacter(int lP, int st) {
		this.LifePoints = lP;
		this.strength = st;
		this.gold = 0;
	}

	/**
	 * Gives the life points of the GameCharacter object.
	 * @return life points of this game character.
	 */
	public int getLifePoints() {
		return this.LifePoints;
	}

	/**
	 * Method that moves the GameCharacter object to a certain Room.
	 * @param r The room to which the character should be moved to.
	 */
	public void moveTo(Room r) {
		this.currentRoom = r;
	}

	/**
	 * Gives the Room in which the GameCharacter object is located in.
	 * @return the room that the character is in.
	 */
	public Room currentRoom() {
		return this.currentRoom;
	}

	/**
	 * Gives the strength of this GameCharacter object.
	 * @return The strength of this character.
	 */
	public int getStrength() {
		return this.strength;
	}

	/**
	 * Method that adds strength points to the character
	 * @param st the number of strength points to add
	 */
	public void addStrength(int st) {
		this.strength += st;
	}

	/**
	 * Gives the gold coins that the character possesses 
	 * @return the number of gold coins that the character has.
	 */
	public int getGold() {
		return this.gold;
	}

	/**
	 * Method that gives gold coins to the character
	 * @param g the number of gold coins to give
	 */
	public void addGold(int g) {
		this.gold += g;
	}

	/**
	 * Tells whether the character is alive, or not
	 * @return true if character is alive, false otherwise
	 */
	public boolean isAlive() {
		return this.getLifePoints() > 0;
	}

	/**
	 * Removes life points from the player.
	 * @param st number of life points to remove
	 */
	public void loseLife(int st) {
		this.LifePoints -= st;
	}
	
	/**
	 * Attack method. Template method that defines how a character attacks another.
	 * The default behavior is the character issuing the attack hits the other and
	 * the other doesn't (!) respond. The hit() and gotHitBy() methods complement 
	 * this one by defining behavior in different cases.
	 * @param theOtherCharacterToAttack The character this character object will attack.
	 */
	public void attack(GameCharacter theOtherCharacterToAttack) {
		theOtherCharacterToAttack.loseLife(this.getStrength());
		hit();
		if (theOtherCharacterToAttack.isAlive()) {
			gotHitBy(theOtherCharacterToAttack);
		} else {
			theOtherCharacterToAttack.die();
		}
	}

	/**
	 * Abstract method, defining what happens when this character hits another.
	 */
	protected abstract void hit();
	
	 /**
	  * Abstract method defining what happens when this character gets 
	  * hit by another one.
	  * @param attacker the character this is attacking this one.
	  */
	protected abstract void gotHitBy(GameCharacter attacker);
	
	/**
	 * Abstract method killing the character and defining what happens
	 * when he dies.
	 */
	public abstract void die();
	
	/**
	 * The description of this Character. See Lookable doc.
	 */
	public abstract String description();
	
	/**
	 * Abstract method defining the name of the character
	 * @return his name
	 */
	public abstract String name();
}
