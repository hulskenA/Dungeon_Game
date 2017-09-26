package fil.coo.adventure.entities.monsters;

import java.util.Random;

import fil.coo.adventure.entities.GameCharacters;

public class Monster extends GameCharacters {
	public Monster(int lP, int st) {
		super(lP, st);
		Random r = new Random();
		this.gold = r.nextInt();
	}
	
	public String toString() {
		return "Monster : LP:"+this.getLifePoints()+", SP: "+this.getStrength();
	}
}
