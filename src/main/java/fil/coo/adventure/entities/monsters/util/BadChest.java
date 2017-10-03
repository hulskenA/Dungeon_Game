package fil.coo.adventure.entities.monsters.util;

import java.util.Random;

import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.GoldPouch;
import fil.coo.adventure.entities.monsters.SpecialMonster;
import fil.coo.adventure.util.langages.Translator;

/**
 * This class represents the bad chest monster :
 * It is a special monster. (See fil.coo.adventure.entities.monster.SpecialMonster)
 * Attacks like a regular monster, except that every time it does
 * it has a chance of dropping a gold pouch on the floor of the room it is in.
 * When it dies, it reverts back to being a normal gold chest that the player 
 * can pick up.
 * @author VASILEV Martin, HULSKEN Alexandre
 *
 */
public class BadChest extends SpecialMonster {
	public BadChest(int lp, int sp) {
		super(lp, sp);
	}

	@Override
	public String name() {
		return Translator.translate("BadChest");
	}

	@Override
	/**
	 * See Special Monster documentation
	 */
	public void onDieEffect() {
		this.currentRoom().addItem(new GoldChest());
		this.currentRoom().removeDead(this);
		System.out.println("\t> "+Translator.translate("BadChestDie"));
	}

	@Override
	/**
	 * See Special Monster documentation
	 */
	public void onAttackEffect(GameCharacter gm) {
		Random r = new Random();
		if (r.nextBoolean()) {
			this.currentRoom().addItem(new GoldPouch());
			System.out.println("\t> "+Translator.translate("BadChestEffect"));
		}
	}

	@Override
	public String description() {
		return this.name()+"\n\t["+Translator.translate("BadChestDescription")+"]";
	}
}
