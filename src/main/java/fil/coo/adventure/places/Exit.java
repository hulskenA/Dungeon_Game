package fil.coo.adventure.places;

import fil.coo.adventure.AdventureGame;

public class Exit extends Room {
	public Exit() {
		super();
	}
	
	public boolean isExit() {
		return true;
	}
	
	public String toString() {
		return AdventureGame.TRANSLATOR.translate("ExitToString");
	}
}
