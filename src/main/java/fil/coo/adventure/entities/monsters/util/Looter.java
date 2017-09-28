package fil.coo.adventure.entities.monsters.util;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.monsters.Monster;

public class Looter extends Monster {
	public Looter() {
		super(20, 20);
	}
	
	public String name() {
		return "Looter";
	}

	@Override
	public String description() {
		return this.name()+"\n\t[I hate them, je vais devoir faire attention à mon or parce que J'AIME l'argeeeeent]";
	}

	public void specialeffect(GameCharacters gm) {
		gm.addGold(-10);
		this.addGold(10);
		System.out.println("\t> Le pillard vient de vous volez 10 pièces d'or");
	}
}
