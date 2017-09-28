package fil.coo.adventure.entities.monsters.util;

import java.util.Random;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.GoldStockExchage;
import fil.coo.adventure.entities.monsters.Monster;

public class BadChest extends Monster {
	public BadChest() {
		super(25, 5);
	}
	
	public String name() {
		return "BadChest";
	}

	public void specialeffect(GameCharacters gm) {
		Random r = new Random();
		if (r.nextBoolean()) {
			this.currentRoom().addItem(new GoldStockExchage());
			System.out.println("\t> En essayant de vous mordre il a fait tomber une poigné de pièce d'or");
		}
	}

	@Override
	public String description() {
		return this.name()+"\n\t[Ce coffre a des dents et il n'hésitera pas s'en servir]";
	}
	
	public void die() {
		this.currentRoom().addItem(new GoldChest());
		this.currentRoom().removeCharacter(this);
		System.out.println("\t> Maintenant qu'il est mort je peux recupérer l'or sans perdre de doigts");
	}
}
