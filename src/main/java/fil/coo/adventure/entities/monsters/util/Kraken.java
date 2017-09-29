package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.monsters.Monster;

public class Kraken extends Monster {
	public Kraken() {
		super(60, 15);
	}
	
	public String name() {
		return AdventureGame.TRANSLATOR.translate("Kraken");
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.TRANSLATOR.translate("KrakenDescription")+"]";
	}
}
