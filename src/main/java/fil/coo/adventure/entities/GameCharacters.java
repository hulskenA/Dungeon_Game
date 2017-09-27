package fil.coo.adventure.entities;

import fil.coo.adventure.places.Room;

public abstract class GameCharacters {
	
	protected Room currentRoom;
	protected int LifePoints;
	protected int strength;
	protected int gold;
	
	public GameCharacters() {
		this.LifePoints = 0;
		this.strength = 0;
		this.gold = 0;
	}
	
	public GameCharacters(int lP, int st) {
		this.LifePoints = lP;
		this.strength = st;
		this.gold = 0;
	}
	
	public int getLifePoints() {
		return this.LifePoints;
	}
	
	public void moveTo(Room r) {
		this.currentRoom = r;
	}
	
	public Room currentRoom() {
		return this.currentRoom;
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public int getGold() {
		return this.gold;
	}
	
	public void addGold(int g) {
		this.gold += g;
	}
	
	public boolean isAlive() {
		return this.getLifePoints() > 0;
	}
	
	public void loseLife(int st) {
		this.LifePoints -= st;
	}
	
	public abstract void die();
	
	public void attack(GameCharacters theOtherCharacterToAttack) {
		/* The GameCharacter issuing the attack hits the other character */
		theOtherCharacterToAttack.loseLife(this.getStrength());
		/* If the other thing dies, it cannot counter-attack */
		if (theOtherCharacterToAttack.isAlive()) {
			/* Otherwise, it counter-attacks. */
			this.loseLife(theOtherCharacterToAttack.getStrength());
			/* Did the other character kill the attacker ? */
			if (!this.isAlive()) {
				/* Yes he did */
				this.die();
			}
		} else {
			/* The attacker killed the other character */
			theOtherCharacterToAttack.die();
		}
	}
}
