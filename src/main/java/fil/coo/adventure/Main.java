package fil.coo.adventure;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.entities.actions.util.*;

public class Main {

	public static void main(String[] args) {
		Player thePlayer = new Player(15,5);
		thePlayer.addCapability(new AttackAction());
		thePlayer.addCapability(new LookAction());
		thePlayer.addCapability(new MoveAction());
		thePlayer.addCapability(new UseAction());
		AdventureGame aG = new AdventureGame(Room.generateMap(),thePlayer);
		aG.play();
		System.out.println("Under construction");
	}

}
