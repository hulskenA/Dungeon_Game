package adventure;

import adventure.AdventureGame;
import adventure.places.Room;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdventureGame aG = new AdventureGame(Room.generateMap());
		aG.toString();
		System.out.println("Coucou");
	}

}
