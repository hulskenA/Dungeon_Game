package fil.coo.adventure.places;

import java.util.Random;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.util.Lookable;

public enum Direction implements Lookable {
	N(AdventureGame.TRANSLATOR.translate("North")),
	S(AdventureGame.TRANSLATOR.translate("South")),
	E(AdventureGame.TRANSLATOR.translate("East")),
	W(AdventureGame.TRANSLATOR.translate("West"));
	
	private String name;
	
	private Direction(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
	
	public static Direction alea() {
		Random r = new Random();
		Direction[] directions = Direction.values();
		return directions[r.nextInt(directions.length)];
	}
	
	public Direction opposite() {
		 switch(this) {
		 	case N:
		 		return Direction.S;
		 	case S:
		 		return Direction.N;
		 	case E:
		 		return Direction.W;
		 	default:
		 		return Direction.E;
		 }
	}

	public String description() {
		return AdventureGame.TRANSLATOR.translate("AGate")+this.toString();
	}
}
