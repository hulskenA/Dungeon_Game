package fil.coo.adventure.places;

import java.util.Random;

import fil.coo.adventure.util.Lookable;
import fil.coo.adventure.util.langages.Translator;

/**
 * Defines all possible directions that a player can take 
 * when wanting to move between the rooms of the dungeon.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public enum Direction implements Lookable {
	N("North"),
	S("South"),
	E("East"),
	W("West");
	
	private String name;
	
	private Direction(String name) {
		this.name = name;
	}
	
	public String toString() {
		return Translator.translate(this.name);
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

	/**
	 * See Lookable interface documentation
	 */
	public String description() {
		return Translator.translate("AGate")+" "+this.toString();
	}
}
