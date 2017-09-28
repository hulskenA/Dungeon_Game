package fil.coo.adventure.entities;

import fil.coo.adventure.places.Room;
import fil.coo.adventure.util.Lookable;

public abstract class GameCharacters implements Lookable {
	
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
	
	public void addStrength(int st) {
		this.strength += st;
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
	
	public abstract String description();
	public abstract void attack(GameCharacters theOtherCharacterToAttack);
	
//	public void attack(GameCharacters theOtherCharacterToAttack) {
//		/* The GameCharacter issuing the attack hits the other character */
//		theOtherCharacterToAttack.loseLife(this.getStrength());
//		System.out.println("\t> It lost "+this.getStrength()+" Life Points");
//		/* If the other thing dies, it cannot counter-attack */
//		if (theOtherCharacterToAttack.isAlive()) {
//			/* Otherwise, it counter-attacks. */
//			this.loseLife(theOtherCharacterToAttack.getStrength());
//			System.out.println("\t> He ripostes and you lost "+theOtherCharacterToAttack.getStrength()+" Life Points\n\t> Now you have "+this.getLifePoints()+" LP");
//			/* Did the other character kill the attacker ? */
//			if (!this.isAlive()) {
//				/* Yes he did */
//				System.out.println("\t> You are died\n\t> You have lose this game\n\t> You are a shit\n\t> Ahahahah !!!");
//				this.die();
//			}
//		} else {
//			/* The attacker killed the other character */
//			System.out.println("\t> He is died now !!! :D");
//			theOtherCharacterToAttack.die();
//		}
//	}**/
}
