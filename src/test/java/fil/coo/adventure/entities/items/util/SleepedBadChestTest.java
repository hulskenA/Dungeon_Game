package fil.coo.adventure.entities.items.util;

import static org.junit.Assert.*;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.ItemTest;
import fil.coo.adventure.places.Room;

public class SleepedBadChestTest extends ItemTest {

	@Override
	public void isUsedByAffectsPlayerTest() {
		/* The SleepedBadChest when used turns into a BadChest monster (meaning
		 * it is removed from the item's list and put into the monsters list) */
		Player p = new Player(100,15);
		Room r = new Room();
		Item i = new SleepedBadChest();
		p.moveTo(r);
		r.addItem(i);
		assertTrue(r.getItems().contains(i));
		assertTrue(r.getCharacters().isEmpty()); // Empty because new Room();
		i.isUsedBy(p);
		assertFalse(r.getItems().contains(i));
		assertFalse(r.getCharacters().isEmpty()); // No longer empty because a BadChest is in it;
	}

}
