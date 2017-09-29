package fil.coo.adventure.entities.monsters.util;

import java.util.Random;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.GoldStockExchage;
import fil.coo.adventure.entities.monsters.Monster;

public class BadChest extends Monster {
	public BadChest() {
		super(25, 5);
	}
	
	public String name() {
		return AdventureGame.TRANSLATOR.translate("BadChest");
	}

	public void specialeffect(GameCharacters gm) {
		Random r = new Random();
		if (r.nextBoolean()) {
			this.currentRoom().addItem(new GoldStockExchage());
			System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("BadChestEffect"));
		}
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.TRANSLATOR.translate("BadChestDescription")+"]";
	}
	
	public void die() {
		this.currentRoom().addItem(new GoldChest());
		this.currentRoom().removeCharacter(this);
		System.out.println("\t> "+AdventureGame.TRANSLATOR.translate("BadChestDie"));
	}
}
