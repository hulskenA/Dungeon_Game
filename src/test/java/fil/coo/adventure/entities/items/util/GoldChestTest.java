package fil.coo.adventure.entities.items.util;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.ItemTest;
import fil.coo.adventure.places.Room;

public class GoldChestTest extends ItemTest {
	
	@Override
	public void isUsedByAffectsPlayerTest() {
		/* The gold chest gives the Player 100 gold coins 
		 * and then disappears from the room's list of items */
		Player p = new Player(100,15);
		Room r = new Room();
		p.moveTo(r);
		Item i = this.createGoldChest();
		r.addItem(i);
		assertEquals(0,p.getGold());
		assertTrue(r.getItems().contains(i));
		i.isUsedBy(p);
		assertEquals(this.goldChestValue(),p.getGold());
		assertFalse(r.getItems().contains(i));
	}

	protected Item createGoldChest() {
		return new GoldChest();
	}
	
	protected int goldChestValue() {
		return 100;
	}
}
