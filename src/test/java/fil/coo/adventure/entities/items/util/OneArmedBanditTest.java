package fil.coo.adventure.entities.items.util;

import static org.junit.Assert.*;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.ItemTest;
import fil.coo.adventure.places.Room;

public class OneArmedBanditTest extends ItemTest {

	@Override
	public void isUsedByAffectsPlayerTest() {
		/* A one-armed bandit drops a random item on the floor
		 * and disappears in doing so and player loses 100 gold for using it */
		Player p = new Player(100,15);
		Room r = new Room();
		Item i = new OneArmedBandit();
		p.addGold(150); // Player needs gold to use OneArmedBandit
		p.moveTo(r);
		r.addItem(i);
		assertTrue(r.getItems().contains(i));
		i.isUsedBy(p);
		assertFalse(r.getItems().contains(i));
		// Cannot be empty as the one armed bandit dropped an item
		assertFalse(r.getItems().isEmpty());
		assertEquals(50,p.getGold());
	}
}
