package adventure.entities;

import java.util.Random;

public abstract class Monster extends GameCharacters {
	public Monster(int lP, int st) {
		super(lP, st);
		Random r = new Random();
		this.gold = r.nextInt();
	}
}
