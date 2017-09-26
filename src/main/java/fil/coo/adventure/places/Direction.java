package fil.coo.adventure.places;

import java.util.Random;

public enum Direction {
	N("north"),
	S("south"),
	E("east"),
	W("west");
	
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
		// switch(this.name) {
		// 	case "north":
		// 		return Direction.S;
		// 	case "south":
		// 		return Direction.N;
		// 	case "east":
		// 		return Direction.W;
		// 	default:
		// 		return Direction.E;
		// }
	    return Direction.S;
	}
}
