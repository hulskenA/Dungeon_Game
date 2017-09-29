package fil.coo.adventure.places;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.monsters.util.Dragon;

public class Exit extends Room {
	public Exit() {
		super();
		this.addCharacter(new Dragon());
	}
	
	public boolean isExit() {
		return true;
	}
	
	public String toString() {
		return AdventureGame.TRANSLATOR.translate("ExitToString");
	}
}
