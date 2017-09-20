package adventure.places;

import adventure.entities.monsters.Dragon;

public class Exit extends Room {
	public Exit() {
		super();
		this.monsters.add(new Dragon());
	}
	
	public boolean isExit() {
		return true;
	}
}
