package fil.coo.adventure.entities.items.util;

import static org.junit.Assert.*;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.ItemTest;
import fil.coo.adventure.places.Room;

public class LifePotionTest extends ItemTest {

	@Override
	public void isUsedByAffectsPlayerTest() {
		/* The life potion gives the player a number of life points
		 * and is remove from the room, after usage */
		Player p = new Player(10,15);
		Room r = new Room();
		Item i = new LifePotion();
		p.moveTo(r);
		r.addItem(i);
		assertTrue(r.getItems().contains(i));
//		assertEquals(10,p.getLifePoints());
		i.isUsedBy(p);
		assertEquals(60,p.getLifePoints());
		assertFalse(r.getItems().contains(i));
	}

	
}
