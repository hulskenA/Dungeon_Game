package fil.coo.adventure.entities.items.util;

import static org.junit.Assert.*;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.ItemTest;
import fil.coo.adventure.places.Room;

public class StrengthPotionTest extends ItemTest {

	@Override
	public void isUsedByAffectsPlayerTest() {
		/* A strength potion adds strength points to the player
		 * and disappears after being used */
		Player p = new Player(100,15);
		Room r = new Room();
		Item i = new StrengthPotion();
		p.moveTo(r);
		r.addItem(i);
		i.isUsedBy(p);
		assertEquals(30,p.getStrength());
		assertFalse(r.getItems().contains(i));
	}

}
