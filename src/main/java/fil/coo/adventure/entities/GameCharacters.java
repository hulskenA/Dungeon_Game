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
	public abstract String name();
}
