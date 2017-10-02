package fil.coo.adventure.entities.monsters.util;

import java.util.Random;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.GoldStockExchange;
import fil.coo.adventure.entities.monsters.SpecialMonsterAttack;
import fil.coo.adventure.entities.monsters.SpecialMonsterDie;

public class BadChest extends SpecialMonsterAttack implements SpecialMonsterDie {
	public BadChest() {
		super(25, 5);
	}

	@Override
	public String name() {
		return AdventureGame.translator.translate("BadChest");
	}

	@Override
	public void specialeffect() {
		this.currentRoom().addItem(new GoldChest());
		this.currentRoom().removeDead(this);
		System.out.println("\t> "+AdventureGame.translator.translate("BadChestDie"));
	}

	@Override
	public void specialeffect(GameCharacters gm) {
		Random r = new Random();
		if (r.nextBoolean()) {
			this.currentRoom().addItem(new GoldStockExchange());
			System.out.println("\t> "+AdventureGame.translator.translate("BadChestEffect"));
		}
	}
	
	@Override
	public void die() {
		super.die();
		this.specialeffect();
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+AdventureGame.translator.translate("BadChestDescription")+"]";
	}
}
